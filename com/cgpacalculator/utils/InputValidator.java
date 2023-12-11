package com.cgpacalculator.utils;

public class InputValidator {
    public static boolean isValidCourseScore(int courseScore) {
        return courseScore >= 0 && courseScore <= 100;
    }

    public static boolean isValidCourseNameAndCode(String courseName) {
        String regex = "^[\\p{L}0-9.#]+\\s\\d{3}$";
        return courseName != null && !courseName.trim().isEmpty() && courseName.matches(regex);
    }

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
