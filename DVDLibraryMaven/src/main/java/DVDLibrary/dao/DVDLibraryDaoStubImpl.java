/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryDaoStubImpl implements DVDLibraryDao {

    DVD onlyDVD;
    private List<DVD> dvdlist = new ArrayList<>();
    private Map<String, DVD> dvds = new HashMap<>();

    public DVDLibraryDaoStubImpl() {
        onlyDVD = new DVD("Rambo");
        onlyDVD.setReleaseDate(LocalDate.parse("08/01/1980"));
        onlyDVD.setMpaaRating("R");
        onlyDVD.setDirectorName("Stallone");
        onlyDVD.setStudio("MGM");
        ArrayList<String> userRating = new ArrayList<>();
        userRating.add("Great film!");
        onlyDVD.setUserRating(userRating);

        dvds.put("Rambo", onlyDVD);
        dvdlist.add(onlyDVD);
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dvdlist;
    }

    @Override
    public void addNote(String title, String userRating1) throws DVDLibraryPersistenceException{
        if (title.equals(onlyDVD.getTitle())){
            ArrayList<String> userRating = onlyDVD.getUserRating();
            userRating.add(userRating1);
            onlyDVD.setUserRating(userRating);
        } else {
            
        }
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD editDVD(String title, DVD dvd) {
        if (title.equals(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD getDVD(String title) {
        if (title.equals(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public Map<String, List<DVD>> getDVDByDirectorSortedByMpaaRating(String directorName) {
        return dvds.values()
                .stream()
                .filter(s -> s.getDirectorName().equalsIgnoreCase(directorName))
                .collect(Collectors.groupingBy(DVD::getMpaaRating));
    }

    @Override
    public Map<String, List<DVD>> getAllDVDsGroupByMpaaRating() throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .collect(Collectors.groupingBy(DVD::getMpaaRating));
    }

    @Override
    public List<DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .filter(s -> s.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> getDVDsWithinLastNYears(int ageInYears) {
        return dvds.values()
                .stream()
                .filter(s -> s.getDVDAge() <= ageInYears)
                .collect(Collectors.toList());

    }

    @Override
    public List<DVD> getDVDsByStudio(String studio) throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());

    }

    @Override
    public double getAverageDVDAge() throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .mapToLong(s -> s.getDVDAge())
                .average()
                .getAsDouble();
    }

    @Override
    public DVD getNewestDVD() throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .min((dvd1, dvd2) -> Long.compare(dvd1.getDVDAge(), dvd2.getDVDAge()))
                .get();

    }

    @Override
    public DVD getOldestDVD() throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .max((dvd1, dvd2) -> Long.compare(dvd1.getDVDAge(), dvd2.getDVDAge()))
                .get();

    }

    @Override
    public double getAverageNumberOfNotes() throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .filter(s -> s.getUserRating() != null)
                .count();
    }

    @Override
    public void loadLibrary() throws DVDLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveLibrary() throws DVDLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
