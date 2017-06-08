package com.swccorp.flooring.model;

import java.math.BigDecimal;
import java.util.Objects;

public class TaxInfo {
  public static final int NUMBER_OF_FIELDS = 3;

  private String stateAbbreviation;
  private String stateName;
  private BigDecimal rate;

  public String getStateAbbreviation() {
    return stateAbbreviation;
  }

  public void setStateAbbreviation(String stateAbbreviation) {
    this.stateAbbreviation = stateAbbreviation;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TaxInfo taxInfo = (TaxInfo) o;
    return Objects.equals(stateAbbreviation, taxInfo.stateAbbreviation) &&
            Objects.equals(stateName, taxInfo.stateName) &&
            Objects.equals(rate, taxInfo.rate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateAbbreviation, stateName, rate);
  }

  @Override
  public String toString() {
    return "TaxInfo{" +
            "stateAbbreviation='" + stateAbbreviation + '\'' +
            ", stateName='" + stateName + '\'' +
            ", rate=" + rate +
            '}';
  }
}
