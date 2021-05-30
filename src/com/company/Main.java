package com.company;

import com.company.calculator.Calculator;
import com.company.calculator.CurrencyCalculator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    Calculator calculator;
    Scanner scanner;

    public Main() {
        this.calculator = new CurrencyCalculator();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.GUI();
    }

    private void GUI() {

        boolean loopActive = true;

        while (loopActive) {

            System.out.println();
            System.out.println("******** KALKULATOR WALUT ********");
            System.out.println();
            System.out.println("Kalkulator zainicjalizowany : " + Objects.nonNull(calculator));
            System.out.println("Skaner zainicjalizowany : " + Objects.nonNull(scanner));
            System.out.println("Waluty zainicjalizowane : " + calculator.currencyMapInitialized());
            System.out.println();
            System.out.println("1. Załaduj wartości walut");
            System.out.println("2. Lista walut");
            System.out.println("3. Przelicz euro na ...");
            System.out.println("4. Zakończ działanie");

            try {
                int selected = scanner.nextInt();

                switch (selected) {
                    case 1:
                        System.out.println("Podaj nazwę pliku ( resources/currencyResource.xml )");
                        String filename = scanner.next();
                        calculator.loadCurrencyMap(filename);
                        break;
                    case 2:
                        for (Map.Entry<String, BigDecimal> entry : calculator.getCurrencyMap().entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                        break;
                    case 3:
                        System.out.println("Podaj wartość w EUR");
                        BigDecimal eur = scanner.nextBigDecimal();
                        System.out.println("Podaj symbol waluty do przeliczenia");
                        String currency = scanner.next();
                        System.out.println(eur + " EUR = "  + calculator.convertEuroTo(eur, currency) + " " + currency);
                        break;
                    case 4:
                        loopActive = false;
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Runtime exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
