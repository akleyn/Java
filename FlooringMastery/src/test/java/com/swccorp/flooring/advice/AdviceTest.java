package com.swccorp.flooring.advice;


import com.swccorp.flooring.model.TaxInfo;
import com.swccorp.flooring.service.DataModificationException;
import com.swccorp.flooring.model.NewOrderRequest;
import com.swccorp.flooring.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class AdviceTest
{
    private OrderService service;
    private LoggingAdvice loggingAdvice;

    public AdviceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        service = ctx.getBean("orderService", OrderService.class);
        loggingAdvice = ctx.getBean("loggingAdvice", LoggingAdvice.class);
    }


    @Test(expected = DataModificationException.class)
    public void testAudit() throws DataModificationException
    {
        NewOrderRequest request = new NewOrderRequest(LocalDate.now(), "", "", "", BigDecimal.valueOf(1));

        service.addOrder(request);

        verify(loggingAdvice, times(1)).writeAuditEntry(any());
    }

    @Test(expected = DataModificationException.class)
    public void testExceptions() throws DataModificationException
    {
        TaxInfo t = service.getTaxInfo("W");

        verify(loggingAdvice, times(1)).logMethodThrewException(any(), any());
    }
}