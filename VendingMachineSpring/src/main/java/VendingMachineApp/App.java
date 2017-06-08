package VendingMachineApp;

import VendingMachine.Dao.VendingMachineDaoException;
import VendingMachine.Dao.VendingMachinePersistenceException;
import VendingMachine.Service.VendingMachineDataValidationException;
import VendingMachine.Service.VendingMachineDuplicateIdException;
import VendingMachine.Service.VendingMachineInsufficientFundsException;
import VendingMachineController.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author softwareguild
 */
public class App {
    public static void main(String[] args) {
        //UserIO myIo = new UserIOFileImpl();
        //VendingMachineView myView = new VendingMachineView(myIo);
        //VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        //VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        
        //VendingMachineServiceLayer myService = new VendingMachineServiceLayerFileImpl(myDao, myAuditDao);
        //VendingMachineController controller = new VendingMachineController(myService, myView);
        //controller.run();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}

