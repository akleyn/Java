package com.swccorp.flooring.service;

import com.swccorp.flooring.model.NewOrderRequest;
import com.swccorp.flooring.model.Order;
import com.swccorp.flooring.model.UpdateOrderRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OrderServiceTest {
    private OrderService service;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        service = context.getBean(OrderService.class);
    }

    @Test
    public void getOrdersForDate() throws Exception {
        List<Order> orders = service.getOrdersForDate(LocalDate.of(2013, Month.JUNE, 1));

        assertEquals(2, orders.size());

        Order order1 = orders.get(0);
        assertEquals(1, order1.getNumber());
        assertEquals("Wise", order1.getCustomerName());
        assertEquals("OH", order1.getTaxInfo().getStateAbbreviation());
        assertEquals("Wood", order1.getProduct().getType());
        assertEquals(new BigDecimal("100.0"), order1.getArea());
        assertEquals(new BigDecimal("515.0"), order1.getMaterialCost());
        assertEquals(new BigDecimal("475.0"), order1.getLaborCost());
        assertEquals(new BigDecimal("61.88"), order1.getTax());
        assertEquals(new BigDecimal("1051.88"), order1.getTotal());

        Order order2 = orders.get(1);
        assertEquals(2, order2.getNumber());
        assertEquals("John", order2.getCustomerName());
        assertEquals("CA", order2.getTaxInfo().getStateAbbreviation());
        assertEquals("Carpet", order2.getProduct().getType());
        assertEquals(new BigDecimal("200.0"), order2.getArea());
        assertEquals(new BigDecimal("615.0"), order2.getMaterialCost());
        assertEquals(new BigDecimal("575.0"), order2.getLaborCost());
        assertEquals(new BigDecimal("71.88"), order2.getTax());
        assertEquals(new BigDecimal("2051.88"), order2.getTotal());
    }

    @Test
    public void getOrder() throws Exception {
        Order order = service.getOrder(LocalDate.of(2013, Month.JUNE, 1), 1).get();

        assertEquals(1, order.getNumber());
        assertEquals("Wise", order.getCustomerName());
        assertEquals("OH", order.getTaxInfo().getStateAbbreviation());
        assertEquals("Wood", order.getProduct().getType());
        assertEquals(new BigDecimal("100.0"), order.getArea());
        assertEquals(new BigDecimal("515.0"), order.getMaterialCost());
        assertEquals(new BigDecimal("475.0"), order.getLaborCost());
        assertEquals(new BigDecimal("61.88"), order.getTax());
        assertEquals(new BigDecimal("1051.88"), order.getTotal());
    }

    @Test
    public void addOrder() throws Exception {
        LocalDate date = LocalDate.now();
        NewOrderRequest request = new NewOrderRequest(date, "Bill", "CA", "Tile",BigDecimal.valueOf(140));


        service.addOrder(request);

        Order order = service.getOrder(date, 1).get();

        assertEquals(1, order.getNumber());
        assertEquals("Bill", order.getCustomerName());
        assertEquals("CA", order.getTaxInfo().getStateAbbreviation());
        assertEquals("Tile", order.getProduct().getType());
        assertEquals(new BigDecimal("140"), order.getArea());
        assertEquals(new BigDecimal("490.00"), order.getMaterialCost());
        assertEquals(new BigDecimal("581.00"), order.getLaborCost());
        assertEquals(new BigDecimal("77.65"), order.getTax());
        assertEquals(new BigDecimal("1148.65"), order.getTotal());
    }

    @Test
    public void updateOrder() throws Exception {
        UpdateOrderRequest request = new UpdateOrderRequest("Bill", "CA", "Tile",BigDecimal.valueOf(140));


        LocalDate date = LocalDate.of(2013, Month.JUNE, 1);
        Order order = service.getOrder(date, 1).get();
        service.updateOrder(date, order, request);

        Order updatedOrder = service.getOrder(date, 1).get();
        assertEquals(1, updatedOrder.getNumber());
        assertEquals("Bill", updatedOrder.getCustomerName());
        assertEquals("CA", updatedOrder.getTaxInfo().getStateAbbreviation());
        assertEquals("Tile", updatedOrder.getProduct().getType());
        assertEquals(new BigDecimal("140"), updatedOrder.getArea());
        assertEquals(new BigDecimal("490.00"), updatedOrder.getMaterialCost());
        assertEquals(new BigDecimal("581.00"), updatedOrder.getLaborCost());
        assertEquals(new BigDecimal("77.65"), updatedOrder.getTax());
        assertEquals(new BigDecimal("1148.65"), updatedOrder.getTotal());
    }

    @Test
    public void deleteOrder() throws Exception {
        LocalDate date = LocalDate.of(2013, Month.JUNE, 1);
        service.deleteOrder(date, 1);
        Optional<Order> orderOptional = service.getOrder(date, 1);
        assertFalse(orderOptional.isPresent());
    }
}