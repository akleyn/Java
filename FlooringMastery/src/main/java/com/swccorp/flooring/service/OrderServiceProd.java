package com.swccorp.flooring.service;

import com.swccorp.flooring.dao.*;

class OrderServiceProd extends OrderService {

    public OrderServiceProd(OrderDao orderDao, NewOrderRequestDao newOrderRequestDao, UpdateOrderRequestDao updateOrderRequestDao, TaxDao taxDao, ProductDao productDao) {
        super(orderDao,newOrderRequestDao, updateOrderRequestDao, taxDao, productDao );
    }

    @Override
    public void saveWork() {
        orderDao.saveChanges();
        newOrderRequestDao.saveChanges();
        updateOrderRequestDao.saveChanges();
    }

    @Override
    public boolean hasWorkToSave() {

        return orderDao.hasUnsavedChanges() || newOrderRequestDao.hasUnsavedChanges() || updateOrderRequestDao.hasUnsavedChanges();

    }

}
