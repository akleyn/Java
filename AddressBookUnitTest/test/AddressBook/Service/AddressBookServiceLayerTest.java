/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.Service;

import AddressBook.dao.AddressBookAuditDao;
import AddressBook.dao.AddressBookAuditDaoStubImpl;
import AddressBook.dao.AddressBookDao;
import AddressBook.dao.AddressBookDaoStubImpl;
import AddressBook.dao.AddressBookPersistenceException;
import AddressBook.dto.AddressBook;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author softwareguild
 */
public class AddressBookServiceLayerTest {

    private AddressBookServiceLayer service;

    public AddressBookServiceLayerTest() {
        AddressBookDao dao = new AddressBookDaoStubImpl();
        AddressBookAuditDao auditDao = new AddressBookAuditDaoStubImpl();
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
     * Test of addAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testAddAddress() throws Exception {
        AddressBook address = new AddressBook("Smith");
        address.setFirstName("Joe");
        address.setStreetNumber("1111");
        address.setStreetName("Maple Street");
        address.setCity("Jackson");
        address.setState("Mississippi");
        address.setZipCode("25252");
        service.addAddress(address);

    }

    @Test
    public void testAddAddressDuplicateID() throws Exception {
        AddressBook address = new AddressBook("Smith");
        address.setFirstName("Joe");
        address.setStreetNumber("1111");
        address.setStreetName("Maple Street");
        address.setCity("Jackson");
        address.setState("Mississippi");
        address.setZipCode("25252");

        try {
            service.addAddress(address);
            fail("Expected AddressBookDuplicateIdException was not thrown");
        } catch (AddressBookDuplicateIdException e) {
            return;
        }
    }

    @Test
    public void testAddAddressInvalidData() throws Exception {
        AddressBook address = new AddressBook("Smith");
        address.setFirstName("Joe");
        address.setStreetNumber("1111");
        address.setStreetName("Maple Street");
        address.setCity("Jackson");
        address.setState("Mississippi");
        address.setZipCode("25252");

        try {
            service.addAddress(address);
            fail("Expected AddressBookDataValidationException was not thrown");
        } catch (AddressBookDataValidationException e) {
            return;
        }

    }

    /**
     * Test of getAllAddresses method, of class AddressBookServiceLayer.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        assertEquals(1, service.getAllAddresses().size());
    }

    /**
     * Test of getAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testGetAddress() throws Exception {
        AddressBook address = service.getAddress("Smith");
        assertNotNull(address);
        address = service.getAddress("Jones");
        assertNull(address);
    }

    /**
     * Test of removeAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testRemoveAddress() throws Exception {
       AddressBook address = service.removeAddress("Smith");
       assertNotNull(address);
       address = service.removeAddress("Jones");
       assertNull(address);
    }

    /**
     * Test of editAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testEditAddress() throws Exception {
        AddressBook address = new AddressBook("Smith");
        address.setFirstName("Joe");
        address.setStreetNumber("1111");
        address.setStreetName("Maple Street");
        address.setCity("Jackson");
        address.setState("Mississippi");
        address.setZipCode("25252");
        service.editAddress(address.getLastName(), address);
        
        assertEquals(service.getAddress("Smith"), address);
        
    }

}
