package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        productDao = context.getBean(ProductDao.class);
    }

    @Test
    public void getProductByType() throws Exception {
        Product product = productDao.getProductByType("Laminate").get();

        assertEquals("Laminate", product.getType());
        assertEquals(new BigDecimal("1.75"), product.getCostPerSquareFoot());
        assertEquals(new BigDecimal("2.10"), product.getLaborCostPerSquareFoot());
    }
}