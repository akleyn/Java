package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.TaxInfo;

import java.util.Optional;

public interface TaxDao {
    Optional<TaxInfo> getTaxForState(String state);
}
