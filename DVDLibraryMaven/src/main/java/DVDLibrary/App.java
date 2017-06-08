/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary;

import DVDLibrary.Service.DVDLibraryDataValidationException;
import DVDLibrary.Service.DVDLibraryDuplicateIdException;
import DVDLibrary.Service.DVDLibraryServiceLayer;
import DVDLibrary.Service.DVDLibraryServiceLayerImpl;
import DVDLibrary.dao.DVDLibraryAuditDao;
import DVDLibrary.dao.DVDLibraryAuditDaoFileImpl;
import DVDLibrary.dao.DVDLibraryDao;
import DVDLibrary.dao.DVDLibraryDaoFileImpl;
import DVDLibrary.dao.DVDLibraryPersistenceException;
import DVDLibrary.ui.DVDLibraryView;
import DVDLibrary.ui.UserIO;
import DVDLibrary.ui.UserIOFileImpl;
import DVDLibraryController.DVDLibraryController;

/**
 *
 * @author softwareguild
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DVDLibraryDuplicateIdException, DVDLibraryDataValidationException, DVDLibraryPersistenceException{
        UserIO myIo = new UserIOFileImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryAuditDao myAuditDao = new DVDLibraryAuditDaoFileImpl();
        
        DVDLibraryServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao, myAuditDao);
        DVDLibraryController controller = new DVDLibraryController(myService, myView);
        controller.run();
    }
    
}
