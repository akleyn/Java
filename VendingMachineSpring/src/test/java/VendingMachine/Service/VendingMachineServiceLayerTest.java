/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;


import VendingMachine.dto.Item;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author softwareguild
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;
    BigDecimal funds = new BigDecimal("0");

    public VendingMachineServiceLayerTest() {
                ApplicationContext ctx = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
        service = 
            ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayer.
     */
    /**
     * Test of getFunds method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetFunds() {
        service.addFunds(BigDecimal.ONE);
        assertEquals(BigDecimal.ONE, service.getFunds());
    }

    /**
     * Test of getItemQuantity method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItemQuantity() {
        BigDecimal bd = new BigDecimal("3");
        service.addFunds(bd);

        Item item1 = service.getItem("Famous Amos");
        assertEquals(10, item1.getQuantity());
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItem() {
        Item item = service.getItem("Famous Amos");
        assertNotNull(item);
        assertEquals(item, service.getItem("Famous Amos"));
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() {
        Item item = service.getItem("Famous Amos");

        assertEquals(item, service.getItem("Famous Amos"));

    }


    /**
     * Test of remainingFunds method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testRemainingFunds() {
        BigDecimal bd = new BigDecimal("3");
        service.addFunds(bd);
        Item item1 = service.getItem("Famous Amos");
        service.remainingFunds(item1);
        BigDecimal bd2 = new BigDecimal("1.75");
        assertEquals(bd2, service.getFunds());

    }

    /**
     * Test of checkForInsufficientFunds method, of class
     * VendingMachineServiceLayer.
     */
    @Test
    public void testPurchaseItem() {
        BigDecimal bd = new BigDecimal("125");
        service.addFunds(bd);
        Item item1 = new Item("Famous Amos");
        BigDecimal itemCost = new BigDecimal("1.25");
        item1.setCost(itemCost);
        service.purchaseItem(item1);
        
        BigDecimal updatedFunds = service.getFunds();
        
        
        BigDecimal bd3 = new BigDecimal("0.00");
        assertEquals(bd3, updatedFunds);
    }

    /**
     * Test of addFunds method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testAddFunds() {
        BigDecimal bd = new BigDecimal("300");
        service.addFunds(bd);

        assertEquals(service.getFunds(), bd);
    }

}
