package com.cgpacalculator.utils;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the user input is a positive number
     * @param prompt
     * @return
     */
    public static int retrievePositiveNumber(String prompt) {
        int value;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();
            

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid number between 1 and 24 inclusive.");
                continue;
            }

            int inputInt = Integer.parseInt(inputValue);

            if (inputInt <= 0 || inputInt > 24) {
                System.out.println("Invalid input. Please enter a valid number between 1 and 24 inclusive.");
                continue;
            }


            value = Integer.parseInt(inputValue);
            if (value > 0) break;
        }
        return value;
    }

    /**
     * Gets the course code from the user
     * @param prompt
     * @return
     */
    public static String retrieveCourseNameAndCode(String prompt) {
        String courseName;

        while (true) {
            System.out.print(prompt);
            courseName = scanner.nextLine();

            if (InputValidator.isValidCourseNameAndCode(courseName)) {
                break;
            }

            System.out.println("Wrong course code. Please enter a valid one starting with at least one alphabet, then a space and ending with 3 digits eg. MEG 503.");
        }
        return courseName;
    }

    /**
     * Gets the course score from the user
     * @param prompt
     * @return
     */
    public static int retrieveCourseScore(String prompt) {
        int courseScore;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid course score.");
                continue;
            }

            courseScore = Integer.parseInt(inputValue);
            
            if (!InputValidator.isValidCourseScore(courseScore)) {
                System.out.printf("Course Score Should be between %d and %d\n", 0, 100);
                continue;
            }
            
            break;
        }
        
        return courseScore;
    }

    /**
     * Gets the course Unit from the user
     * @param prompt
     * @return
     */
    public static int retrieveCourseUnit(String prompt) {
        int courseUnit;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input, Please enter a valid course unit between 0 and 6");
                continue;
            }

            int unitInt = Integer.parseInt(inputValue);
            if (unitInt <= 0 || unitInt > 6) {
                System.out.println("Invalid input, Please enter a valid course unit between 0 and 6");
                continue;
            }

            courseUnit = Integer.parseInt(inputValue);
            break;
        }

        return courseUnit;
    }
}
