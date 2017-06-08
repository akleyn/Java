package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileProductDao implements ProductDao {
    private final Path fileName;

    public FileProductDao(Path fileName) {
        this.fileName = fileName;
    }

    private Map<String, Product> productByType;

    public void init() {
        productByType = groupByType(loadAllProducts());
    }

    private List<Product> loadAllProducts() {
        try {
            return Files.lines(fileName)
                    .map(this::parseProduct)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private Map<String, Product> groupByType(List<Product> products) {
        Map<String, Product> productByName = new HashMap<>();
        products.forEach(product -> {
            Product existing = productByName.put(product.getType(), product);
            if (existing != null) {
                throw new IllegalArgumentException("Duplicate record for the " + product.getType() + " product");
            }
        });
        return Collections.unmodifiableMap(productByName);
    }

    private Product parseProduct(String line) {
        String[] tokens = line.split("\\s*,\\s*");
        if (tokens.length != Product.NUMBER_OF_FIELDS) {
            throw new PersistenceException(String.format(
                    "Product record contains %s fields, expected %s", tokens.length, Product.NUMBER_OF_FIELDS));
        }
        int i = 0;
        Product product = new Product();
        product.setType(tokens[i++]);
        product.setCostPerSquareFoot(new BigDecimal(tokens[i++]));
        product.setLaborCostPerSquareFoot(new BigDecimal(tokens[i]));
        return product;
    }

    @Override
    public Optional<Product> getProductByType(String type) {
        Product product = productByType.get(type);
        return Optional.ofNullable(product);
    }
}
