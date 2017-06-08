/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibraryController;

import DVDLibrary.Service.DVDLibraryDataValidationException;
import DVDLibrary.Service.DVDLibraryDuplicateIdException;
import DVDLibrary.Service.DVDLibraryServiceLayer;
import DVDLibrary.dao.DVDLibraryPersistenceException;
import DVDLibrary.dto.DVD;
import DVDLibrary.ui.DVDLibraryView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryController {

    DVDLibraryView view;
    private DVDLibraryServiceLayer service;

    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
        this.service = service;
        this.view = view;

    }

    public void run() throws DVDLibraryDuplicateIdException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    editDVD();
                    break;
                case 5:
                    removeDVD();
                    break;
                case 6:
                    addNote();
                    break;
                case 7:
                    getNewestDVD();
                    break;
                case 8:
                    getOldestDVD();
                    break;
                case 9:
                    getDVDsWithinLastNYears();
                    break;

                case 10:
                    getAverageDVDAge();
                    break;
                case 11:
                    getDVDsByStudio();
                    break;

                case 12:
                    getDVDByDirectorSortedByMpaaRating();
                    break;

                case 13:
                    getAllDVDsGroupByMpaaRating();
                    break;
                case 14:
                    getAverageNumberOfNotes();
                    break;
                case 15:
                    try {
                        this.service.loadLibrary();
                    } catch (DVDLibraryDataValidationException ex) {
                        view.exception();
                    }
                    break;
                case 16:
                    try {
                        this.service.saveLibrary();
                    } catch (DVDLibraryDataValidationException ex) {
                        view.exception();
                    }
                    break;
                case 17:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }

        view.goodbye();

    }

    private void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        service.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryPersistenceException {
        List<DVD> dvdList = service.getAllDVDs();

        view.displayDVDList(dvdList);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDuplicateIdException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        service.addDVD(newDVD);
        view.displayCreateSuccessBanner();
    }

    private void editDVD() throws DVDLibraryPersistenceException {
        view.displayEditDVDBanner();
        DVD dvd = view.editNewDVDInfo();
        service.editDVD(dvd.getTitle(), dvd);
        view.displayEditSuccessBanner();
    }

    private void viewDVD() throws DVDLibraryPersistenceException {
        String title = view.getTitleChoice();
        DVD dvd = service.getDVD(title);
        view.displayDVD(dvd);

    }
    
    private void addNote() throws DVDLibraryPersistenceException {
        String title = view.getTitleChoice();
        String note = view.addNote();
        service.addNote(title, note);
        
        //view.displayCreateDVDBanner();
        //DVD newDVD = view.getNewDVDInfo();
        //service.addDVD(newDVD);
        //view.displayCreateSuccessBanner();
    }

    private void getNewestDVD() throws DVDLibraryPersistenceException {
        DVD dvd = service.getNewestDVD();
        view.displayDVD(dvd);
    }

    private void getOldestDVD() throws DVDLibraryPersistenceException {
        DVD dvd = service.getOldestDVD();
        view.displayDVD(dvd);
    }

    private void getDVDsWithinLastNYears() throws DVDLibraryPersistenceException {
        int number = view.getNumberOfYears();
        List<DVD> dvdList = service.getDVDsWithinLastNYears(number);
        view.printNumberOfYears(number);
        view.displayDVDList(dvdList);
    }

    private void getAverageDVDAge() throws DVDLibraryPersistenceException {
        double num = service.getAverageDVDAge();
        view.getAverageDVDAge(num);
    }

    private void getDVDsByStudio() throws DVDLibraryPersistenceException {
        String studio = view.getStudio();
        List<DVD> dvdList = service.getDVDsByStudio(studio);
        view.printDVDsFromStudio(studio);
        view.displayDVDList(dvdList);
    }

    private void getDVDByDirectorSortedByMpaaRating() throws DVDLibraryPersistenceException {
        String director = view.getDirectorName();

        Map<String, List<DVD>> dvdMapList = service.getDVDByDirectorSortedByMpaaRating(director);

        Iterator it = dvdMapList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            view.displayDVDsByDirectorsSortedByMpaaRating(pair.getKey().toString());

            view.printTitle(pair.getValue().toString());

            it.remove();

        }

    }

    private void getAllDVDsGroupByMpaaRating() throws DVDLibraryPersistenceException {
        Map<String, List<DVD>> dvdMapList = service.getAllDVDsGroupByMpaaRating();
        Iterator it = dvdMapList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            view.displayDVDsGroupedByMpaaRating(pair.getKey().toString());

            view.printTitle(pair.getValue().toString());

            it.remove();

        }

    }
    
    private void getAverageNumberOfNotes() throws DVDLibraryPersistenceException{
        double num = service.getAverageNumberOfNotes();
        view.printAverageNumberOfNotes(num);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
