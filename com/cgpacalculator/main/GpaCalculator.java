package com.cgpacalculator.main;

import com.cgpacalculator.models.Course;
import com.cgpacalculator.services.GpaCalculationService;
import com.cgpacalculator.utils.Console;
/**
 * The main GPA CALCULATOR
 */
public class GpaCalculator {

    public static void main(String[] args) {
        System.out.println("My GPA Calculator");

        int maxCoursesInSemester = Console.retrievePositiveNumber("Enter the number of Courses between 1 and 24 inclusive: ");
        Course[] courses = new Course[maxCoursesInSemester];


        for (int i = 0; i < maxCoursesInSemester; i++) {
            Course course = captureCourseInput(i);
            // Add the course to the array
            courses[i] = course;
        }

        printCourseInfo(courses);

        double gpa = GpaCalculationService.calculateGPA(courses);
        System.out.printf("\nYour GPA is: %.2f\n", gpa);
    }
/**
 * Prints out the course Info
 * @param courses
 */
    private static void printCourseInfo(Course[] courses) {
        System.out.println("\nCourse details and grades:\n");

        System.out.println("|---------------|-------------|-------|------------|");
        System.out.println("| COURSE & CODE | COURSE UNIT | GRADE | GRADE-UNIT |");
        System.out.println("|---------------|-------------|-------|------------|");

        for (Course course : courses) {
            String grade = GpaCalculationService.convertToLetterGrade(course.getScore());
            int gradePoint = GpaCalculationService.convertToNumericGrade(course.getScore());

            System.out.format("| %-14s| %-11s | %-5s | %-10s |\n",
                    course.getCourseNameAndCode(), course.getUnits(), grade, gradePoint);
        }
        System.out.println("|--------------------------------------------------|");
    }
/**
 * Takes the course details from the user
 * @param index
 * @return
 */
    private static Course captureCourseInput(int index) {
        int count = index + 1;
        System.out.println("\nEnter details for Course #" + count);

        String courseNameAndCode = Console.retrieveCourseNameAndCode("Course Name And Code: ");
        int units = Console.retrieveCourseUnit("Units: ");
        double score = Console.retrieveCourseScore("Score: ");

        return new Course(courseNameAndCode, units, score);
    }
}