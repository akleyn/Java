package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.TaxInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxDaoTest {
    private TaxDao taxDao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        taxDao = context.getBean(TaxDao.class);
    }

    @Test
    public void getTaxForState() throws Exception {
        TaxInfo taxInfo = taxDao.getTaxForState("OH").get();

        assertEquals("OH", taxInfo.getStateAbbreviation());
        assertEquals("Ohio", taxInfo.getStateName());
        assertEquals(new BigDecimal("6.25"), taxInfo.getRate());
    }
}