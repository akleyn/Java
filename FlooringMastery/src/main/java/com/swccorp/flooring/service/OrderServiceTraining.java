package com.swccorp.flooring.service;

import com.swccorp.flooring.dao.*;

class OrderServiceTraining extends OrderService {

    OrderServiceTraining(OrderDao orderDao, NewOrderRequestDao newOrderRequestDao, UpdateOrderRequestDao updateOrderRequestDao, TaxDao taxDao, ProductDao productDao) {
        super(orderDao,newOrderRequestDao, updateOrderRequestDao, taxDao, productDao );
    }

    @Override
    public void saveWork() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasWorkToSave() {
        return false;
    }
}
