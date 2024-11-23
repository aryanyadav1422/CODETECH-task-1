
import java.util.Scanner;

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grades Manager!");

        // Input the number of subjects/assignments
        System.out.print("Enter the number of subjects/assignments: ");
        int numSubjects = getValidNumber(scanner);

        if (numSubjects <= 0) {
            System.out.println("Error: Number of subjects must be greater than 0.");
            return;
        }

        double[] grades = new double[numSubjects];
        double total = 0.0;

        // Input grades for each subject/assignment
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the grade for subject/assignment " + (i + 1) + ": ");
            grades[i] = getValidGrade(scanner);
            total += grades[i];
        }

        // Calculate average grade
        double average = total / numSubjects;

        // Display the overall grade, letter grade, and GPA
        System.out.println("\n--- Grades Summary ---");
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Subject/Assignment %d: %.2f%n", i + 1, grades[i]);
        }

        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f%n", calculateGPA(average));

        System.out.println("Thank you for using the Student Grades Manager!");
        scanner.close();
    }

    // Method to ensure valid input for the number of subjects
    private static int getValidNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Method to ensure valid grade input (0-100)
    private static double getValidGrade(Scanner scanner) {
        double grade;
        while (true) {
            if (scanner.hasNextDouble()) {
                grade = scanner.nextDouble();
                if (grade >= 0 && grade <= 100) {
                    break;
                }
            } else {
                scanner.next(); // Discard invalid input
            }
            System.out.print("Invalid input. Please enter a grade between 0 and 100: ");
        }
        return grade;
    }

    // Method to calculate the letter grade
    private static String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to calculate GPA (4.0 scale)
    private static double calculateGPA(double average) {
        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
