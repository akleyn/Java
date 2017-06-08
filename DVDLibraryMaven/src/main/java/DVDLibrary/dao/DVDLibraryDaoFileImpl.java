/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD newDVD = dvds.put(title, dvd);
        return newDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) {
        DVD newDVD = dvds.put(title, dvd);
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = dvds.remove(title);
        return removedDVD;
    }
    
    @Override 
    public void addNote(String title, String userRating1){
        DVD dvd = dvds.get(title);
        ArrayList<String> userRating = dvd.getUserRating();
        userRating.add(userRating1);
        dvd.setUserRating(userRating);
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
    public double getAverageNumberOfNotes() throws DVDLibraryPersistenceException{
        return dvds.values()
                .stream()
                .mapToLong(s -> s.getUserRating().size())
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
    public void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- Could not load library data into memory.", e);
        }
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER

        String[] currentTokens;
        ArrayList<String> userRating = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setReleaseDate(LocalDate.parse(currentTokens[1]));
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            userRating.add(currentTokens[5]);
            currentDVD.setUserRating(userRating);

            dvds.put(currentDVD.getTitle(), currentDVD);

        }
        scanner.close();
    }

    @Override
    public void saveLibrary() throws DVDLibraryDaoException {
        try {

            List<DVD> dvds = getAllDVDs();
            String line = "";
            for (DVD currentDVD : dvds) {

                line = line + currentDVD.getTitle()
                        + DELIMITER + currentDVD.getDirectorName()
                        + DELIMITER + currentDVD.getMpaaRating()
                        + DELIMITER + currentDVD.getReleaseDate()
                        + DELIMITER + currentDVD.getStudio()
                        + DELIMITER + currentDVD.getUserRating();

            }
            BufferedWriter out = new BufferedWriter(new FileWriter(LIBRARY_FILE));

            out.write(line);
            out.close();
        } catch (IOException e) {
            System.out.println("Exception!");
        }

    }
}
