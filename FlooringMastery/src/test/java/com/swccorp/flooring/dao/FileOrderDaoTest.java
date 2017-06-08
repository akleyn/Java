package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class FileOrderDaoTest {
    private OrderDao orderDao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        orderDao = context.getBean(OrderDao.class);
    }

    @Test
    public void getOrdersForDate() throws Exception {
        Map<Long, Order> orders = orderDao.getOrdersForDate(LocalDate.of(2013, Month.JUNE, 1));

        assertEquals(2, orders.size());

        Order order1 = orders.get(1L);
        assertEquals(1, order1.getNumber());
        assertEquals("Wise", order1.getCustomerName());
        assertEquals("OH", order1.getTaxInfo().getStateAbbreviation());
        assertEquals("Wood", order1.getProduct().getType());
        assertEquals(BigDecimal.valueOf(100.0), order1.getArea());
        assertEquals(BigDecimal.valueOf(515.0), order1.getMaterialCost());
        assertEquals(BigDecimal.valueOf(475.0), order1.getLaborCost());
        assertEquals(BigDecimal.valueOf(61.88), order1.getTax());
        assertEquals(BigDecimal.valueOf(1051.88), order1.getTotal());

        Order order2 = orders.get(2L);
        assertEquals(2, order2.getNumber());
        assertEquals("John", order2.getCustomerName());
        assertEquals("CA", order2.getTaxInfo().getStateAbbreviation());
        assertEquals("Carpet", order2.getProduct().getType());
        assertEquals(BigDecimal.valueOf(200.0), order2.getArea());
        assertEquals(BigDecimal.valueOf(615.0), order2.getMaterialCost());
        assertEquals(BigDecimal.valueOf(575.0), order2.getLaborCost());
        assertEquals(BigDecimal.valueOf(71.88), order2.getTax());
        assertEquals(BigDecimal.valueOf(2051.88), order2.getTotal());
    }

    @Test
    public void getOrder() throws Exception {
        Optional<Order> orderOptional = orderDao.getOrder(LocalDate.of(2013, Month.JUNE, 1), 1);
        Order order = orderOptional.get();

        assertEquals(1, order.getNumber());
        assertEquals("Wise", order.getCustomerName());
        assertEquals("OH", order.getTaxInfo().getStateAbbreviation());
        assertEquals("Wood", order.getProduct().getType());
        assertEquals(BigDecimal.valueOf(100.0), order.getArea());
        assertEquals(BigDecimal.valueOf(515.0), order.getMaterialCost());
        assertEquals(BigDecimal.valueOf(475.0), order.getLaborCost());
        assertEquals(BigDecimal.valueOf(61.88), order.getTax());
        assertEquals(BigDecimal.valueOf(1051.88), order.getTotal());
    }

    @Test
    public void putOrder() throws Exception {
        Order newOrder = new Order();
        newOrder.setNumber(100);
        LocalDate date = LocalDate.now();

        orderDao.putOrder(date, newOrder);

        Order retrievedOrder = orderDao.getOrder(date, 100).get();

        assertSame(newOrder, retrievedOrder);
    }

    @Test
    public void deleteOrder() throws Exception {
        LocalDate date = LocalDate.of(2013, Month.JUNE, 1);
        boolean removed = orderDao.removeOrder(date, 1);

        assertTrue(removed);

        Optional<Order> retrievedOrderOptional = orderDao.getOrder(date, 1);
        assertFalse(retrievedOrderOptional.isPresent());
    }

    @Test
    public void trackUnsavedChangesIfOrderAdded() throws Exception {
        assertFalse(orderDao.hasUnsavedChanges());

        Order newOrder = new Order();
        newOrder.setNumber(100);
        LocalDate date = LocalDate.now();

        orderDao.putOrder(date, newOrder);

        assertTrue(orderDao.hasUnsavedChanges());
    }

    @Test
    public void trackUnsavedChangesIfOrderDeleted() throws Exception {
        assertFalse(orderDao.hasUnsavedChanges());

        orderDao.removeOrder(LocalDate.of(2013, Month.JUNE, 1), 1);

        assertTrue(orderDao.hasUnsavedChanges());
    }
}
