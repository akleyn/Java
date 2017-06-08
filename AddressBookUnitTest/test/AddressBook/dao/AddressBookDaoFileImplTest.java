/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

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
public class AddressBookDaoFileImplTest {

    private AddressBookDao daoImpl = new AddressBookDaoFileImpl();

    public AddressBookDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<AddressBook> addresses = daoImpl.getAllAddresses();
        for (AddressBook address : addresses) {
            daoImpl.removeAddress(address.getLastName());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testAddAddress() throws AddressBookPersistenceException {
        AddressBook address = new AddressBook("Doe");
        address.setFirstName("John");

        address.setStreetNumber("1111");
        address.setStreetName("Oak Road");
        address.setCity("Portland");
        address.setState("Oregon");
        address.setZipCode("97201");

        daoImpl.addAddress(address.getLastName(), address);

        AddressBook fromDao = daoImpl.getAddress(address.getLastName());

        assertEquals(address, fromDao);
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        AddressBook address1 = new AddressBook("Doe");
        address1.setFirstName("John");
        address1.setStreetNumber("1111");
        address1.setStreetName("Oak Road");
        address1.setCity("Portland");
        address1.setState("Oregon");
        address1.setZipCode("97201");

        daoImpl.addAddress(address1.getLastName(), address1);

        AddressBook address2 = new AddressBook("Smith");
        address2.setFirstName("Joe");
        address2.setStreetNumber("2222");
        address2.setStreetName("Maple Lane");
        address2.setCity("Los Angeles");
        address2.setState("California");
        address2.setZipCode("90210");

        daoImpl.addAddress(address2.getLastName(), address2);

        assertEquals(2, daoImpl.getAllAddresses().size());

    }

    /**
     * Test of getAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testGetAddress() throws Exception {
        AddressBook address = new AddressBook("Doe");
        address.setFirstName("John");

        address.setStreetNumber("1111");
        address.setStreetName("Oak Road");
        address.setCity("Portland");
        address.setState("Oregon");
        address.setZipCode("97201");

        daoImpl.addAddress(address.getLastName(), address);

        AddressBook fromDao = daoImpl.getAddress(address.getLastName());

        assertEquals(address, fromDao);
    }

    /**
     * Test of editAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testEditAddress() throws Exception {
        AddressBook address1 = new AddressBook("Doe");
        address1.setFirstName("John");

        address1.setStreetNumber("1111");
        address1.setStreetName("Oak Road");
        address1.setCity("Portland");
        address1.setState("Oregon");
        address1.setZipCode("97201");

        daoImpl.addAddress(address1.getLastName(), address1);

        
        
        AddressBook address2 = new AddressBook("Doe");
        address2.setFirstName("Joe");
        address2.setStreetNumber("2222");
        address2.setStreetName("Maple Lane");
        address2.setCity("Los Angeles");
        address2.setState("California");
        address2.setZipCode("90210");

        daoImpl.editAddress(address1.getLastName(), address2);
        
        AddressBook fromDao = daoImpl.getAddress(address2.getLastName());
        
        assertEquals(address2, fromDao);

        

    }

    /**
     * Test of removeAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        AddressBook address1 = new AddressBook("Doe");
        address1.setFirstName("John");
        address1.setStreetNumber("1111");
        address1.setStreetName("Oak Road");
        address1.setCity("Portland");
        address1.setState("Oregon");
        address1.setZipCode("97201");

        daoImpl.addAddress(address1.getLastName(), address1);

        AddressBook address2 = new AddressBook("Smith");
        address2.setFirstName("Joe");
        address2.setStreetNumber("2222");
        address2.setStreetName("Maple Lane");
        address2.setCity("Los Angeles");
        address2.setState("California");
        address2.setZipCode("90210");

        daoImpl.addAddress(address2.getLastName(), address2);

        daoImpl.removeAddress(address1.getLastName());
        assertEquals(1, daoImpl.getAllAddresses().size());
        assertNull(daoImpl.getAddress(address1.getLastName()));

        daoImpl.removeAddress(address2.getLastName());
        assertEquals(0, daoImpl.getAllAddresses().size());
        assertNull(daoImpl.getAddress(address2.getLastName()));

    }

    /**
     * Test of totalNumberAddresses method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testTotalNumberAddresses() throws Exception {
        assertEquals(0, daoImpl.getAllAddresses().size());

        AddressBook address1 = new AddressBook("Doe");
        address1.setFirstName("John");
        address1.setStreetNumber("1111");
        address1.setStreetName("Oak Road");
        address1.setCity("Portland");
        address1.setState("Oregon");
        address1.setZipCode("97201");

        daoImpl.addAddress(address1.getLastName(), address1);

        assertEquals(1, daoImpl.getAllAddresses().size());

        AddressBook address2 = new AddressBook("Smith");
        address2.setFirstName("Joe");
        address2.setStreetNumber("2222");
        address2.setStreetName("Maple Lane");
        address2.setCity("Los Angeles");
        address2.setState("California");
        address2.setZipCode("90210");

        daoImpl.addAddress(address2.getLastName(), address2);

        assertEquals(2, daoImpl.getAllAddresses().size());
    }


}
