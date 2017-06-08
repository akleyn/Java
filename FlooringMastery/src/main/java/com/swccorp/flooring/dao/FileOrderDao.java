package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Order;
import com.swccorp.flooring.model.Product;
import com.swccorp.flooring.model.TaxInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;

public class FileOrderDao implements OrderDao {
    private static final DateTimeFormatter FILE_NAME_PATTERN = DateTimeFormatter.ofPattern("'Orders_'MMddYYYY'.txt'");

    private final Path baseDirectory;
    private final TaxDao taxDao;
    private final ProductDao productDao;
    private final Map<LocalDate, Map<Long, Order>> orderTable = new HashMap<>();
    private final Set<LocalDate> updatedDates = new HashSet<>();

    public FileOrderDao(Path baseDirectory, TaxDao taxDao, ProductDao productDao) {
        this.baseDirectory = baseDirectory;
        this.taxDao = taxDao;
        this.productDao = productDao;
    }

    private void loadDateIfNeeded(LocalDate date) {
        if (!dateLoaded(date)) {
            List<Order> orders = loadOrdersForDate(date);
            Map<Long, Order> ordersByNumber = orderTable.computeIfAbsent(date, d -> new HashMap<>());
            orders.forEach(order -> ordersByNumber.put(order.getNumber(), order));
        }
    }

    private boolean dateLoaded(LocalDate date) {
        return orderTable.containsKey(date);
    }

    private List<Order> loadOrdersForDate(LocalDate date) {
        Path ordersFile = getOrdersFile(date);
        return loadOrdersFromFile(ordersFile);
    }

    private List<Order> loadOrdersFromFile(Path ordersFile) {
        if (!Files.exists(ordersFile)) {
            return Collections.emptyList();
        }
        try {
            return Files.lines(ordersFile)
                    .map(this::parseOrder)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private Order parseOrder(String line) {
        String[] tokens = line.split("\\s*,\\s*");
        if (tokens.length != Order.NUMBER_OF_FIELDS) {
            throw new PersistenceException(String.format(
                    "Order record contains %s fields, expected %s", tokens.length, Order.NUMBER_OF_FIELDS));
        }
        try {
            int i = 0;
            Order order = new Order();
            order.setNumber(Long.valueOf(tokens[i++]));
            order.setCustomerName(tokens[i++]);
            String stateAbbreviation = tokens[i++];
            Optional<TaxInfo> taxInfoOptional = taxDao.getTaxForState(stateAbbreviation);
            TaxInfo taxInfo = taxInfoOptional.orElseThrow(() ->
                    new PersistenceException("No tax info for state " + stateAbbreviation + " found"));
            order.setTaxInfo(taxInfo);
            i++;
            String productType = tokens[i++];
            Optional<Product> productOptional = productDao.getProductByType(productType);
            Product product = productOptional.orElseThrow(() ->
                    new PersistenceException("No product for state " + productType + " found"));
            order.setProduct(product);
            order.setArea(new BigDecimal(tokens[i++]));
            i++;
            i++;
            order.setMaterialCost(new BigDecimal(tokens[i++]));
            order.setLaborCost(new BigDecimal(tokens[i++]));
            order.setTax(new BigDecimal(tokens[i++]));
            order.setTotal(new BigDecimal(tokens[i]));
            return order;
        } catch (NumberFormatException e) {
            throw new PersistenceException(e);
        }
    }

    private Path getOrdersFile(LocalDate date) {
        String simpleFileName = date.format(FILE_NAME_PATTERN);
        return baseDirectory.resolve(simpleFileName);
    }

    @Override
    public Map<Long, Order> getOrdersForDate(LocalDate date) {
        loadDateIfNeeded(date);
        return new HashMap<>(orderTable.get(date));
    }

    @Override
    public Optional<Order> getOrder(LocalDate date, long number) {
        Map<Long, Order> orderByNumber = getOrdersForDate(date);
        Order order = orderByNumber.get(number);
        return Optional.ofNullable(order);
    }

    @Override
    public void putOrder(LocalDate date, Order order) {
        loadDateIfNeeded(date);
        orderTable.get(date).put(order.getNumber(), order);
        updatedDates.add(date);
    }

    @Override
    public boolean removeOrder(LocalDate date, long number) {
        loadDateIfNeeded(date);
        Order removed = orderTable.get(date).remove(number);
        updatedDates.add(date);
        return removed != null;
    }

    @Override
    public boolean hasUnsavedChanges() {
        return !updatedDates.isEmpty();
    }

    @Override
    public void saveChanges() {
        updatedDates.forEach(this::persistOrdersForDate);
        updatedDates.clear();
    }

    private void persistOrdersForDate(LocalDate date) {
        Path file = getOrdersFile(date);
        try {
            Collection<Order> orders = getOrdersForDate(date).values();
            if (orders.isEmpty()) {
                Files.deleteIfExists(file);
            } else {
                List<String> lines = orders.stream().map(this::marshalOrder).collect(Collectors.toList());
                Files.write(file, lines, WRITE, TRUNCATE_EXISTING, CREATE);
            }
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private String marshalOrder(Order order) {
        String[] values = {
                String.valueOf(order.getNumber()),
                String.valueOf(order.getCustomerName()),
                String.valueOf(order.getTaxInfo().getStateAbbreviation()),
                String.valueOf(order.getTaxInfo().getRate()),
                String.valueOf(order.getProduct().getType()),
                String.valueOf(order.getArea()),
                String.valueOf(order.getProduct().getCostPerSquareFoot()),
                String.valueOf(order.getProduct().getLaborCostPerSquareFoot()),
                String.valueOf(order.getMaterialCost()),
                String.valueOf(order.getLaborCost()),
                String.valueOf(order.getTax()),
                String.valueOf(order.getTotal())
        };
        return String.join(",", values);
    }
}
