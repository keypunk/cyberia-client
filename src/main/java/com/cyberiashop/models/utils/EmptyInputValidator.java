package com.cyberiashop.models.utils;

public class EmptyInputValidator {
    public static boolean isEmpty(String... inputs) {
        for (String input : inputs) {
            if (input.isEmpty())
                return true;
        }

        return false;
    }
}
