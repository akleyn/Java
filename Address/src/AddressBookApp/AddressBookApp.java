/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookApp;

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
        AddressBookController controller = new AddressBookController(myDao, myView);
        controller.run();
    }
    
}
