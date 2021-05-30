package com.company.calculator;

import com.company.parser.CurrencyParserXML;
import com.company.parser.ParserXML;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CurrencyCalculator implements Calculator {

    private final ParserXML parserXML;
    private Map<String, BigDecimal> currencyValues;

    public CurrencyCalculator() {
        this.parserXML = new CurrencyParserXML();
    }

    public boolean currencyMapInitialized() {
        return Objects.nonNull(currencyValues);
    }

    public void loadCurrencyMap(String path) throws Exception {
        currencyValues = parserXML.parse(path);
    }

    @Override
    public Map<String, BigDecimal> getCurrencyMap() {
        if(currencyMapInitialized()) {
            return currencyValues;
        } else {
            throw new IllegalStateException("Map not initialized");
        }
    }

    public BigDecimal convertEuroTo(BigDecimal euro, String currencySymbol) {
        if(currencyMapInitialized()) {
            for (Map.Entry<String, BigDecimal> entry : currencyValues.entrySet()) {
                if (currencySymbol.equals(entry.getKey())) {
                    return euro.multiply(entry.getValue());
                }
            }
            throw new NoSuchElementException("No such currency");
        } else {
            throw new IllegalStateException("Map not initialized");
        }
    }
}
