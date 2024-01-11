package com.cyberiashop.models.utils;

public class EmptyInputValidator {
    public boolean isEmpty(String... inputs) {
        for (String input : inputs) {
            if (input.length() == 0)
                return true;
        }

        return false;
    }
}
