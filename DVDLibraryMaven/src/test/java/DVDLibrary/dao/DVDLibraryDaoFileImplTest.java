/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class DVDLibraryDaoFileImplTest {

    private DVDLibraryDao daoImpl = new DVDLibraryDaoFileImpl();

    public DVDLibraryDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<DVD> dvds = daoImpl.getAllDVDs();
        for (DVD dvd : dvds) {
            daoImpl.removeDVD(dvd.getTitle());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDaoFileImpl.
     */
    @Test
    public void testAddDVD() throws DVDLibraryPersistenceException {
        DVD dvd = new DVD("Rambo");
        dvd.setReleaseDate(LocalDate.parse("08/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));

        dvd.setMpaaRating("R");
        dvd.setDirectorName("Stallone");
        dvd.setStudio("MGM");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("Great film!");
        dvd.setUserRating(userRating);

        daoImpl.addDVD(dvd.getTitle(), dvd);

        DVD fromDao = daoImpl.getDVD(dvd.getTitle());

        assertEquals(dvd, fromDao);
    }

    /**
     * Test of editDVD method, of class DVDLibraryDaoFileImpl.
     */
    @Test
    public void testEditDVD() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));

        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("MGM");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);

        daoImpl.addDVD(dvd1.getTitle(), dvd1);

        DVD dvd2 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("07/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorName("Sylvestor Stallone");
        dvd2.setStudio("Sony");
        ArrayList<String> userRating2 = new ArrayList<>();
        userRating2.add("Fantastic film!");
        dvd2.setUserRating(userRating2);

        daoImpl.editDVD(dvd1.getTitle(), dvd2);

        DVD fromDao = daoImpl.getDVD(dvd2.getTitle());

        assertEquals(dvd2, fromDao);

    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryDaoFileImpl.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);

        daoImpl.addDVD(dvd1.getTitle(), dvd1);

        DVD dvd2 = new DVD("A Beautiful Mind");
        dvd1.setReleaseDate(LocalDate.parse("12/01/2001", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorName("Ron Howard");
        dvd2.setStudio("MGM");
        ArrayList<String> userRating2 = new ArrayList<>();
        userRating2.add("A great drama!");
        dvd2.setUserRating(userRating2);

        daoImpl.addDVD(dvd2.getTitle(), dvd2);

        assertEquals(2, daoImpl.getAllDVDs().size());
    }

    /**
     * Test of getDVD method, of class DVDLibraryDaoFileImpl.
     */
    @Test
    public void testGetDVD() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);


        daoImpl.addDVD(dvd1.getTitle(), dvd1);;

        DVD fromDao = daoImpl.getDVD(dvd1.getTitle());

        assertEquals(dvd1, fromDao);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDaoFileImpl.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd1 = new DVD("Rambo");
        dvd1.setReleaseDate(LocalDate.parse("08/01/1980", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("Stallone");
        dvd1.setStudio("Sony");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("A classic!");
        dvd1.setUserRating(userRating);

        daoImpl.addDVD(dvd1.getTitle(), dvd1);

        DVD dvd2 = new DVD("A Beautiful Mind");
        dvd2.setReleaseDate(LocalDate.parse("12/01/2001", DateTimeFormatter.ofPattern("MM/dd/YYYY")));
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorName("Ron Howard");
        dvd2.setStudio("MGM");
        ArrayList<String> userRating2 = new ArrayList<>();
        userRating.add("A great drama!");
        dvd2.setUserRating(userRating2);

        daoImpl.addDVD(dvd2.getTitle(), dvd2);

        daoImpl.removeDVD(dvd1.getTitle());
        assertEquals(1, daoImpl.getAllDVDs().size());
        assertNull(daoImpl.getDVD(dvd1.getTitle()));

        daoImpl.removeDVD(dvd2.getTitle());
        assertEquals(0, daoImpl.getAllDVDs().size());
        assertNull(daoImpl.getDVD(dvd2.getTitle()));
    }

}
