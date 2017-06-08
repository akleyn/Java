package VendingMachine.Advice;

import VendingMachine.Service.VendingMachineDataValidationException;
import VendingMachine.Service.VendingMachineInsufficientFundsException;
import VendingMachine.Service.VendingMachineNoItemInventoryException;
import VendingMachine.Service.VendingMachineServiceLayer;
import VendingMachine.dto.Item;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class AdviceTest {

    private VendingMachineServiceLayer service;
    private LoggingAdvice loggingAdvice;

    public AdviceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
        loggingAdvice = ctx.getBean("logAdvice", LoggingAdvice.class);
    }

    @Test(expected = VendingMachineInsufficientFundsException.class)
    public void shouldLogInsufficientFundsException() {
        Item item = new Item("Famous Amos", 1, new BigDecimal(1));

        service.purchaseItem(item);

        verify(loggingAdvice, times(1)).logInsufficientFundsException(any(), any());
    }

    @Test(expected = VendingMachineDataValidationException.class)
    public void shouldNotLogItemNotFoundException() {
        Item item = new Item("Hello World", 1, new BigDecimal(1));

        service.purchaseItem(item);

        verify(loggingAdvice, never()).logInsufficientFundsException(any(), any());
    }


    @Test(expected = VendingMachineNoItemInventoryException.class)
    public void shouldLogNoItemsException() {
        Item item = new Item("Famous Amos", 1, new BigDecimal(1));

        service.getItem("Famous Amos").setQuantity(0);
        service.purchaseItem(item);

        verify(loggingAdvice, times(1)).logNoItemInventoryException(any(), any());
    }


}
