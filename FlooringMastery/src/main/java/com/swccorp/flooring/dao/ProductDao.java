package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Product;

import java.util.Optional;

public interface ProductDao {
    Optional<Product> getProductByType(String type);
}
