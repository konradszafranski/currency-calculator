package com.company.calculator;

import java.math.BigDecimal;
import java.util.Map;

public interface Calculator {

    boolean currencyMapInitialized();
    void loadCurrencyMap(String filename) throws Exception;
    Map<String, BigDecimal> getCurrencyMap();
    BigDecimal convertEuroTo(BigDecimal euro, String currencySymbol);
}
