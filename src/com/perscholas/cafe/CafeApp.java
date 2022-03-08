package com.perscholas.cafe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class CafeApp {
    static Product coffee = new Product("coffee", 2.50, "cup of mud");
    static Product espresso = new Product("espresso", 3.50, "strong stuff");
    static Product cappuccino = new Product("cappuccino", 4.00, "espresso, steamed milk, and foam.");
    static BigDecimal coffeeDec = new BigDecimal(coffee.getPrice());
    static BigDecimal cappuccinoDec = new BigDecimal(cappuccino.getPrice());
    static BigDecimal espressoDec = new BigDecimal(espresso.getPrice());

    static BigDecimal salesSubtotal = BigDecimal.ZERO;
    static BigDecimal salesTax = BigDecimal.valueOf(.065);
    static BigDecimal salesTotal = BigDecimal.ZERO;

    public static void main(String[] args) {

        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("'`'`'`'`'`'`'`'`'`'`'");
        System.out.println("WELCOME TO CAFE ROUGE");
        System.out.println("'`'`'`'`'`'`'`'`'`'`'");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        Scanner sc = new Scanner(System.in);
        System.out.println(coffee.getName() + ": '" + coffee.getDescription() + "' " + NumberFormat.getCurrencyInstance().format(coffeeDec));
        System.out.println("How many? ");
        int coffeeQt = sc.nextInt();
        System.out.println(espresso.getName() + ": '" + espresso.getDescription() + "' " + NumberFormat.getCurrencyInstance().format(espressoDec));
        System.out.println("How many? ");
        int espressoQt = sc.nextInt();
        System.out.println(cappuccino.getName() + ": '" + cappuccino.getDescription() + "' " + NumberFormat.getCurrencyInstance().format(cappuccinoDec));
        System.out.println("How many? ");
        int cappuccinoQt = sc.nextInt();
        salesSubtotal = (coffeeDec.multiply(new BigDecimal(coffeeQt))).add(espressoDec.multiply(new BigDecimal(espressoQt))).add(cappuccinoDec.multiply(new BigDecimal(cappuccinoQt)));
        salesSubtotal = salesSubtotal.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Subtotal: $" + salesSubtotal);
        System.out.println("Sales tax is 6.5%.");
        salesTotal = (salesSubtotal.multiply(salesTax)).add(salesSubtotal);
        //TODO: convert all prices to BigDecimal?
        salesTotal = salesTotal.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Total : $" + salesTotal);
        System.out.println("Thank you - exiting.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("'`'`'`'`'`'`'`'`'`'`'");
        System.out.println("-----CAFE ROUGE------");
        System.out.println("'`'`'`'`'`'`'`'`'`'`'");
        System.out.println("vvvvvvvvvvvvvvvvvvvvv");
        sc.close();
    }
}
