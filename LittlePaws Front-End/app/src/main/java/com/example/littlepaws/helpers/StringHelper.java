package com.example.littlepaws.helpers;

public class StringHelper {

    // Set Regular Expeession Pattern for Email:
    public static boolean regexEmailValidationPattern(String email) {
        // Set Pattere:
        String regex = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-z]{2,})";

        if (email.matches(regex)) {
            return true;
        }
        return false;
    }
    // End Of Set Regular Expression Pattern for Email.|
}
