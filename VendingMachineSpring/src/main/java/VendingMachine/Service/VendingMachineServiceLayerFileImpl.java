/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

import VendingMachine.Dao.VendingMachineAuditDao;
import VendingMachine.Dao.VendingMachineDao;
import VendingMachine.dto.Change;
import VendingMachine.dto.Item;
import VendingMachineApp.BigDecimalMath;
import VendingMachineApp.MathOperator;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineServiceLayerFileImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    BigDecimalMath myMath = new BigDecimalMath();
    BigDecimal funds = new BigDecimal("0");

    public VendingMachineServiceLayerFileImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void purchaseItem(Item item) {
        Item item1 = getItem(item.getName());
        assertItemAvailable(item1);
        checkForInsufficientFunds(item1);
        dao.purchaseItem(item1);
        subtractFunds(item1);

    }

    public void subtractFunds(Item item) {
        this.funds = myMath.calculate(MathOperator.MINUS, funds, item.getCost());
    }

    @Override
    public void subtractChange(Change change) {
        this.funds = new BigDecimal(0);
    }

    @Override
    public Item getItem(String item) {
        Item item2 = dao.getItem(item);
        if (item2 == null) {
            throw new VendingMachineDataValidationException("Item not found.");
        }
        return item2;
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public void remainingFunds(Item item) {

        BigDecimal funds = this.funds;
        BigDecimal cost = item.getCost();
        BigDecimal updatedFunds = myMath.calculate(MathOperator.MINUS, funds, cost);

        this.funds = updatedFunds;

    }

    public void checkForInsufficientFunds(Item item) {
        BigDecimal funds = this.funds;
        BigDecimal cost = item.getCost();

        if (cost.intValue() > funds.intValue()) {
            BigDecimal needs = myMath.calculate(MathOperator.MINUS, cost, funds);
            String message = "You need $" + needs.toString() + " more to purchase the item.";
            throw new VendingMachineInsufficientFundsException(message);
        }
    }

    public void assertItemAvailable(Item item) {
        if (item.getQuantity() == 0) {
            throw new VendingMachineNoItemInventoryException("There is no any " + item.getName() + " in machine");
        }
    }

    @Override
    public BigDecimal getFunds(){
        return this.funds;
    }

    @Override
    public void addFunds(BigDecimal amount) {
        this.funds = funds.add(amount);
    }

    @Override
    public Change getChange() {
        BigDecimal remaining = this.getFunds();
        int intValue = (int) (remaining.doubleValue() * 100);

        return new Change(intValue);
    }


}
