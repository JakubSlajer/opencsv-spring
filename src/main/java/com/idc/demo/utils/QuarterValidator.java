package com.idc.demo.utils;

import java.util.regex.Pattern;

public class QuarterValidator {

    /**
     * Validates the string input to be in the right format for Quarter#parseQuarter method
     * @param input quarter string input
     * @return true if the string is valid, else false
     */
    public boolean isValid(String input) {
        String regex = "^((\\d{4}-Q\\d)|Q\\d-\\d{4}$)";
        if (Pattern.matches(regex, input)) {
            return true;
        } else {
            System.out.printf("Input string of %s is not valid quarter value %n", input);
            return false;
        }
    }
}
