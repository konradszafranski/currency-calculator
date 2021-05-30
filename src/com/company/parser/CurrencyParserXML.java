package com.company.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyParserXML implements ParserXML {

    public Map<String, BigDecimal> parse(String path) throws ParserConfigurationException, IOException, SAXException {

            Document document = DocumentBuilderFactory
                                .newInstance()
                                .newDocumentBuilder()
                                .parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Cube");

            Map<String, BigDecimal> currencyMap = new HashMap<>();

            for (int i = 1 ; i < nodeList.getLength() ; i++) {
                Element element = (Element) nodeList.item(i);
                if(element.hasAttribute("currency") && element.hasAttribute("rate")) {
                    currencyMap.put(element.getAttribute("currency"), new BigDecimal(element.getAttribute("rate")));
                }
            }
        return currencyMap;
    }
}
