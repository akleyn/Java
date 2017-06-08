package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.TaxInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileTaxDao implements TaxDao {
    private final Path fileName;
    private Map<String, TaxInfo> taxesByState;

    public FileTaxDao(Path fileName) {
        this.fileName = fileName;
    }

    public void init() {
        taxesByState = groupByState(loadAllTaxes());
    }

    private List<TaxInfo> loadAllTaxes() {
        try {
            return Files.lines(fileName)
                    .map(this::parseTax)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private Map<String, TaxInfo> groupByState(List<TaxInfo> taxInfos) {
        Map<String, TaxInfo> taxesByState = new HashMap<>();
        taxInfos.forEach(tax -> {
            TaxInfo existing = taxesByState.put(tax.getStateAbbreviation(), tax);
            if (existing != null) {
                throw new IllegalArgumentException("Duplicate record for the " + tax.getStateAbbreviation() + " state");
            }
        });
        return Collections.unmodifiableMap(taxesByState);
    }

    private TaxInfo parseTax(String line) {
        String[] tokens = line.split("\\s*,\\s*");
        if (tokens.length != TaxInfo.NUMBER_OF_FIELDS) {
            throw new PersistenceException(String.format(
                    "Tax record contains %s fields, expected %s", tokens.length, TaxInfo.NUMBER_OF_FIELDS));
        }
        try {
            int i = 0;
            TaxInfo taxInfo = new TaxInfo();
            taxInfo.setStateAbbreviation(tokens[i++]);
            taxInfo.setStateName(tokens[i++]);
            taxInfo.setRate(new BigDecimal(tokens[i]));
            return taxInfo;
        } catch (NumberFormatException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Optional<TaxInfo> getTaxForState(String state) {
        TaxInfo taxInfo = taxesByState.get(state);
        return Optional.ofNullable(taxInfo);
    }
}
