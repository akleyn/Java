/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookApp;

import AddressBook.Service.AddressBookServiceLayer;
import AddressBook.Service.AddressBookServiceLayerImpl;
import AddressBook.dao.AddressBookAuditDao;
import AddressBook.dao.AddressBookAuditDaoFileImpl;
import AddressBook.dao.AddressBookDaoFileImpl;
import AddressBook.ui.AddressView;
import AddressBook.ui.UserIO;
import AddressBook.ui.UserIOConsoleImpl;
import AddressBookController.AddressBookController;
import AddressBook.dao.AddressBookDao;

/**
 *
 * @author softwareguild
 */
public class AddressBookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressView myView = new AddressView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookAuditDao myAuditDao = new AddressBookAuditDaoFileImpl();
        AddressBookServiceLayer myService = new AddressBookServiceLayerImpl(myDao, myAuditDao);
        AddressBookController controller = new AddressBookController(myService, myView);
        controller.run();
    }
    
    
       // public static void main(String[] args) throws ClassRosterPersistenceException {
        //UserIO myIo = new UserIOConsoleImpl();
        //ClassRosterView myView = new ClassRosterView(myIo);
        //ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        //ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        //ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        //ClassRosterController controller = new ClassRosterController(myService, myView);
        //controller.run();
}
