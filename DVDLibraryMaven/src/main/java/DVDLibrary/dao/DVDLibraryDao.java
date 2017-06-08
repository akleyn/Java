package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author softwareguild
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String title, DVD dvd) throws DVDLibraryPersistenceException;
    
    DVD editDVD(String title, DVD dvd) throws DVDLibraryPersistenceException;
    
    List<DVD> getAllDVDs() throws DVDLibraryPersistenceException;
    
    DVD getDVD(String title) throws DVDLibraryPersistenceException;
    
    DVD removeDVD(String title) throws DVDLibraryPersistenceException;
    
    List<DVD> getDVDsWithinLastNYears(int ageInYears);
    
    Map<String, List<DVD>> getDVDByDirectorSortedByMpaaRating (String directorName);
    
    Map<String,List<DVD>> getAllDVDsGroupByMpaaRating() throws DVDLibraryPersistenceException;    
    
    List<DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryPersistenceException;
    
    List<DVD> getDVDsByStudio(String studio) throws DVDLibraryPersistenceException;
    
    double getAverageDVDAge() throws DVDLibraryPersistenceException;
    
    double getAverageNumberOfNotes() throws DVDLibraryPersistenceException;

    DVD getNewestDVD() throws DVDLibraryPersistenceException;
    
    DVD getOldestDVD() throws DVDLibraryPersistenceException;
    
    void addNote(String title, String userRating1) throws DVDLibraryPersistenceException;
        
    void loadLibrary() throws DVDLibraryDaoException;
    
    void saveLibrary() throws DVDLibraryDaoException;
}
