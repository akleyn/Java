package com.swccorp.flooring.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserIO {
    void print(String msg);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    int readInt(String prompt, int defaultValue);

    BigDecimal readBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, BigDecimal defaultValue);

    String readString();

    String readString(String prompt);

    String readString(String prompt, String defaultValue);

    LocalDate readDate(String prompt);

    boolean readYesNo();
}
