/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import VendingMachine.Dao.VendingMachineAuditDao;
import VendingMachine.Dao.VendingMachinePersistenceException;
import VendingMachine.Service.VendingMachineInsufficientFundsException;
import VendingMachine.Service.VendingMachineNoItemInventoryException;

/**
 *
 * @author softwareguild
 */
//@Aspect
public class LoggingAdvice {

    private static Log logger = LogFactory.getLog(LoggingAdvice.class);

    private VendingMachineAuditDao auditDao;
 
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
        logException(joinPoint, error);
    }

    @AfterThrowing(pointcut = "execution(* vendingmachine.service.VendingMachineServiceLayerFileImpl.*(..))", throwing = "ex")
    public void logInsufficientFundsException(JoinPoint joinPoint, VendingMachineInsufficientFundsException ex) {
        logException(joinPoint, ex);
    }

    @AfterThrowing(pointcut = "execution(* vendingmachine.service.VendingMachineServiceLayerFileImpl.*(..))", throwing = "ex")
    public void logNoItemInventoryException(JoinPoint joinPoint, VendingMachineNoItemInventoryException ex) {
        logException(joinPoint, ex);
    }

    public void logException(JoinPoint joinPoint, Throwable ex) {
        StringBuilder sb = new StringBuilder();
        sb.append(joinPoint.getSignature().getName() + "(");
        for (Object arg : joinPoint.getArgs()) sb.append(arg);
        sb.append(") ERROR: ");

        sb.append(ex.getClass()).append(": ").append(ex.getMessage());
        sb.append('\n');

        
        logger.info(sb.toString());
    }
}