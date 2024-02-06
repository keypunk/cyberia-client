package com.cyberiashop.controllers.utils;

// To get the price without the currency symbol and then convert the string to a double
public class CurrencyFilter {
    public static double convertPriceLabelToDouble(String priceLabel) {
        String price = priceLabel.substring(0, priceLabel.length() - 1); // removes currency symbol at the end
        return Double.parseDouble(price); // parse to double
    }
}
