/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.Service;

import DVDLibrary.dao.DVDLibraryAuditDao;
import DVDLibrary.dao.DVDLibraryAuditDaoStubImpl;
import DVDLibrary.dao.DVDLibraryDao;
import DVDLibrary.dao.DVDLibraryDaoStubImpl;
import DVDLibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class DVDLibraryServiceLayerTest {
    private DVDLibraryServiceLayer service;

    public DVDLibraryServiceLayerTest() {
        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoStubImpl();
        
        service = new DVDLibraryServiceLayerImpl(dao, auditDao);
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
     * Test of addDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testAddDVD() throws Exception {
        
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980",  DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);
        service.addDVD(dvd1);

    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        assertEquals(1, service.getAllDVDs().size());
    }

    /**
     * Test of getDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVD() throws Exception {
        DVD dvd = service.getDVD("Rambo");
        assertNotNull(dvd);
        dvd = service.getDVD("A Beautiful Mind");
        assertNull(dvd);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd = service.removeDVD("Rambo");
       assertNotNull(dvd);
       dvd = service.removeDVD("A Beautiful Mind");
       assertNull(dvd);
    }

    /**
     * Test of editDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testEditDVD() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980",  DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);
        service.editDVD(dvd1.getTitle(), dvd1);
        
        assertEquals(service.getDVD("Rambo"), dvd1);
    }

    
    @Test
    public void testAddAddressDuplicateID() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980",  DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);

        try {
            service.addDVD(dvd1);
            fail("Expected DVDLibraryDuplicateIdException was not thrown");
        } catch (DVDLibraryDuplicateIdException e) {
            return;
        }
    }

    @Test
    public void testAddAddressInvalidData() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980",  DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);
        try {
            service.addDVD(dvd1);
            fail("Expected DVDLibraryDataValidationException was not thrown");
        } catch (DVDLibraryDataValidationException e) {
            return;
        }

    }
    
}
