
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for the first number
            System.out.print("Enter the first number: ");
            double num1 = getValidNumber(scanner);

            // Prompt the user for the second number
            System.out.print("Enter the second number: ");
            double num2 = getValidNumber(scanner);

            // Display operation choices
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Enter your choice (1-4): ");

            // Get the user's operation choice
            int choice = scanner.nextInt();

            // Perform the selected operation
            double result = performOperation(num1, num2, choice);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Thank you for using the calculator!");
        }
    }

    // Method to ensure valid input for numbers
    private static double getValidNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // Discard invalid input
        }
        return scanner.nextDouble();
    }

    // Method to perform the selected operation
    private static double performOperation(double num1, double num2, int choice) {
        switch (choice) {
            case 1: // Addition
                return num1 + num2;
            case 2: // Subtraction
                return num1 - num2;
            case 3: // Multiplication
                return num1 * num2;
            case 4: // Division
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid choice. Please select an operation between 1 and 4.");
        }
    }
}
