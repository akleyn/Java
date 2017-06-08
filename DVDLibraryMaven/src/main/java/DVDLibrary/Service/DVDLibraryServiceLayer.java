/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.Service;

import DVDLibrary.dao.DVDLibraryPersistenceException;
import DVDLibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author softwareguild
 */
public interface DVDLibraryServiceLayer {
        public void addDVD(DVD dvd) throws DVDLibraryDuplicateIdException,
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;

    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException;

    public DVD getDVD(String title) throws DVDLibraryPersistenceException;

    public DVD removeDVD(String title) throws DVDLibraryPersistenceException;
    
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryPersistenceException;
    
    public List<DVD> getDVDsWithinLastNYears(int ageInYears);
    
    public Map<String, List<DVD>> getDVDByDirectorSortedByMpaaRating (String directorName);
    
    public Map<String,List<DVD>> getAllDVDsGroupByMpaaRating() throws DVDLibraryPersistenceException;    
    
    public List<DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryPersistenceException;
    
    public List<DVD> getDVDsByStudio(String studio) throws DVDLibraryPersistenceException;
    
    public double getAverageDVDAge() throws DVDLibraryPersistenceException;

    public DVD getNewestDVD() throws DVDLibraryPersistenceException;
    
    public DVD getOldestDVD() throws DVDLibraryPersistenceException;
    
    public double getAverageNumberOfNotes() throws DVDLibraryPersistenceException;

    
    public void addNote(String title, String userRating) throws DVDLibraryPersistenceException;
    public void loadLibrary() throws DVDLibraryDataValidationException;
    
    public void saveLibrary() throws DVDLibraryDataValidationException;
    
}
