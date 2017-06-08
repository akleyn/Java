/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.Service;

import DVDLibrary.dao.DVDLibraryAuditDao;
import DVDLibrary.dao.DVDLibraryDao;
import DVDLibrary.dao.DVDLibraryPersistenceException;
import DVDLibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {

    private DVDLibraryDao dao;
    private DVDLibraryAuditDao auditDao;

    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addDVD(DVD dvd) throws DVDLibraryDuplicateIdException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {

        if (dao.getDVD(dvd.getTitle()) != null) {
            throw new DVDLibraryDuplicateIdException("ERROR: Could not create student. Student Id "
                    + dvd.getTitle()
                    + " already exists.");
        }

        validateDVDData(dvd);
        dao.addDVD(dvd.getTitle(), dvd);
        auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " CREATED");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        return dao.getDVD(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(title);
        auditDao.writeAuditEntry("DVD " + title + " REMOVED");
        return removedDVD;

    }

    @Override
    public List<DVD> getDVDsWithinLastNYears(int ageInYears) {
        return dao.getDVDsWithinLastNYears(ageInYears);
    }

    @Override
    public Map<String, List<DVD>> getDVDByDirectorSortedByMpaaRating(String directorName) {
        return dao.getDVDByDirectorSortedByMpaaRating(directorName);
    }

    @Override
    public Map<String, List<DVD>> getAllDVDsGroupByMpaaRating() throws DVDLibraryPersistenceException {
        return dao.getAllDVDsGroupByMpaaRating();
    }

    @Override
    public List<DVD> getDVDsByMpaaRating(String mpaaRating) throws DVDLibraryPersistenceException {
        return dao.getDVDsByMpaaRating(mpaaRating);
    }

    @Override
    public List<DVD> getDVDsByStudio(String studio) throws DVDLibraryPersistenceException {
        return dao.getDVDsByStudio(studio);
    }

    @Override
    public double getAverageDVDAge() throws DVDLibraryPersistenceException {
        return dao.getAverageDVDAge();
    }

    @Override
    public DVD getNewestDVD() throws DVDLibraryPersistenceException {
        return dao.getNewestDVD();
    }

    @Override
    public DVD getOldestDVD() throws DVDLibraryPersistenceException {
        return dao.getOldestDVD();
    }

    @Override
    public double getAverageNumberOfNotes() throws DVDLibraryPersistenceException {
        return dao.getAverageNumberOfNotes();
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryPersistenceException {
        return dao.editDVD(title, dvd);
    }
    
    @Override
    public void addNote(String title, String userRating) throws DVDLibraryPersistenceException{
        dao.addNote(title, userRating);
        
        
        
    }

    private void validateDVDData(DVD dvd) throws DVDLibraryDataValidationException {

        List<String> errorFields = new ArrayList<>();
        if (dvd.getTitle() == null || dvd.getTitle().trim().length() == 0) {
            errorFields.add("title");
        }

        if (dvd.getReleaseDate() == null) {
            errorFields.add("release date");
        }
        
        if (!errorFields.isEmpty()) {
            throw new DVDLibraryDataValidationException("ERROR: All fields [Title, Release Date, MPAA Rating, Director's Name, Studio, User Rating] are required");
        }
        // if (dvd.getTitle() == null || dvd.getTitle().trim().length() == 0
        //         || dvd.getReleaseDate() == null
        //         || dvd.getMpaaRating() == null || dvd.getMpaaRating().trim().length() == 0
        //         || dvd.getDirectorName() == null || dvd.getDirectorName().trim().length() == 0
        //         || dvd.getStudio() == null || dvd.getStudio().trim().length() == 0
        //         || dvd.getUserRating() == null || dvd.getUserRating().isEmpty());
        // {

        // throw new DVDLibraryDataValidationException("ERROR: All fields [Title, Release Date, MPAA Rating, Director's Name, Studio, User Rating] are required");
        // }
    }

    @Override
    public void loadLibrary() throws DVDLibraryDataValidationException {

    }

    @Override
    public void saveLibrary() throws DVDLibraryDataValidationException {

    }

}
