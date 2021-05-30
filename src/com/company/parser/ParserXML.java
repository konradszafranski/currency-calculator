package com.company.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public interface ParserXML {

    Map<String, BigDecimal> parse(String path) throws ParserConfigurationException, IOException, SAXException;
}
