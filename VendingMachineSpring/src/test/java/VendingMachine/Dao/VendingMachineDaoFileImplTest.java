/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.dto.Item;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoFileImplTest {

    private VendingMachineDao daoImpl = new VendingMachineDaoFileImpl();
    public static final String VENDING_FILE = "vending.txt";
    public static final String DELIMITER = "::";
    BigDecimal funds = new BigDecimal("0");
    private Map<String, Item> items = new HashMap<>();

    public VendingMachineDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
            out.println("Cheez It::1.25::10");
            out.println("Dorito's Cool Ranch::1.45::10");
            out.println("Cheetos Crunchy::1.25::9");
            out.println("Gardettos Original::1.25::10");
            out.println("Sun Chips - Hottest Cheddar::1.95::10");
            out.println("Reese's Peanut Butter Cups::1.00::10");
            out.println("Famous Amos::1.25::10");
            out.println("Reese's Pieces Chocolate Candy::1.00::10");
            out.println("Rold Gold- Braided Twists::1.45::10");
            out.println("Snickers::1.00::10");
            out.println("Sun Chips - Original::1.95::10");
            out.println("M&M's Original::1.00::10");
            out.println("Fritos Original::1.45::10");
            out.println("Hershey's Cholocate Bar::1.00::10");
            out.println("Lay's Classic::1.45::10");
            out.println("Austin Cheddar Cheese Crackers::1.00::10");
            out.println("Tom's Potato Chips::1.95::10");
            out.println("Baked! Lays- Barbeque::1.95::10");
            out.println("Hershey's Cookie and Cream::1.00::10");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(VendingMachineDaoFileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
            out.println("Cheez It::1.25::10");
            out.println("Dorito's Cool Ranch::1.45::10");
            out.println("Cheetos Crunchy::1.25::9");
            out.println("Gardettos Original::1.25::10");
            out.println("Sun Chips - Hottest Cheddar::1.95::10");
            out.println("Reese's Peanut Butter Cups::1.00::10");
            out.println("Famous Amos::1.25::10");
            out.println("Reese's Pieces Chocolate Candy::1.00::10");
            out.println("Rold Gold- Braided Twists::1.45::10");
            out.println("Snickers::1.00::10");
            out.println("Sun Chips - Original::1.95::10");
            out.println("M&M's Original::1.00::10");
            out.println("Fritos Original::1.45::10");
            out.println("Hershey's Cholocate Bar::1.00::10");
            out.println("Lay's Classic::1.45::10");
            out.println("Austin Cheddar Cheese Crackers::1.00::10");
            out.println("Tom's Potato Chips::1.95::10");
            out.println("Baked! Lays- Barbeque::1.95::10");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(VendingMachineDaoFileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() {

        assertEquals(19, daoImpl.getAllItems().size());

    }

    /**
     * Test of getItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetItem() {

        Item item1 = new Item("Famous Amos");
        item1.setQuantity(10);
        BigDecimal bd = new BigDecimal("125");
        item1.setCost(bd);
        Item item2 = daoImpl.getItem("Famous Amos");

        item1.equals(item2);
    }

    /**
     * Test of purchaseItem method, of class VendingMachineDao.
     */
    @Test
    public void testPurchaseItem() {

        Item item1 = daoImpl.getItem("Famous Amos");

        daoImpl.purchaseItem(item1);

        assertEquals(9, item1.getQuantity());
    }

    /**
     * Test of loadLibrary method, of class VendingMachineDao.
     */
}
