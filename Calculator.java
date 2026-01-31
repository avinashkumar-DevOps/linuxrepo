/*
 * Simple Console Calculator
 * - Supports addition, subtraction, multiplication, division, modulus, power, and square root
 * - Keeps a small in-memory history of calculations
 * - Robust input validation and helpful prompts
 *
 * Save this file as Calculator.java
 * Compile: javac Calculator.java
 * Run: java Calculator
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Simple Calculator ===");

        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: performBinaryOp("Addition", "+"); break;
                case 2: performBinaryOp("Subtraction", "-"); break;
                case 3: performBinaryOp("Multiplication", "*"); break;
                case 4: performBinaryOp("Division", "/"); break;
                case 5: performBinaryOp("Modulus", "%"); break;
                case 6: performPower(); break;
                case 7: performSqrt(); break;
                case 8: showHistory(); break;
                case 0: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option. Try again.");
            }

            System.out.println(); // blank line between operations
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println(" 1) Add");
        System.out.println(" 2) Subtract");
        System.out.println(" 3) Multiply");
        System.out.println(" 4) Divide");
        System.out.println(" 5) Modulus");
        System.out.println(" 6) Power (x^y)");
        System.out.println(" 7) Square root");
        System.out.println(" 8) Show history");
        System.out.println(" 0) Exit");
    }

    private static void performBinaryOp(String name, String op) {
        double a = readDouble("Enter first number: ");
        double b = readDouble("Enter second number: ");

        double result;
        switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                result = a / b; break;
            case "%":
                if (b == 0) {
                    System.out.println("Error: Modulus by zero is not allowed.");
                    return;
                }
                result = a % b; break;
            default:
                System.out.println("Unknown operation.");
                return;
        }

        String record = String.format("%s: %s %s %s = %s", name, stripTrailingZeros(a), op, stripTrailingZeros(b), stripTrailingZeros(result));
        System.out.println(record.substring(name.length() + 2)); // print just the expression and result
        history.add(record);
    }

    private static void performPower() {
        double base = readDouble("Enter base: ");
        double exp = readDouble("Enter exponent: ");
        double res = Math.pow(base, exp);
        String record = String.format("Power: %s ^ %s = %s", stripTrailingZeros(base), stripTrailingZeros(exp), stripTrailingZeros(res));
        System.out.println(record.substring("Power: ".length()));
        history.add(record);
    }

    private static void performSqrt() {
        double val = readDouble("Enter number (>= 0) for sqrt: ");
        if (val < 0) {
            System.out.println("Error: Cannot compute square root of a negative number.");
            return;
        }
        double res = Math.sqrt(val);
        String record = String.format("Sqrt: sqrt(%s) = %s", stripTrailingZeros(val), stripTrailingZeros(res));
        System.out.println(record.substring("Sqrt: ".length()));
        history.add(record);
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history yet.");
            return;
        }
        System.out.println("History:");
        for (int i = 0; i < history.size(); i++) {
            System.out.printf(" %d) %s%n", i + 1, history.get(i));
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine().trim();
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (e.g., 12.5 or -3). Try again.");
            }
        }
    }

    private static String stripTrailingZeros(double d) {
        // Convert a double to string without unnecessary trailing zeros
        if (d == (long) d) return String.format("%d", (long) d);
        else return String.format("%s", d);
    }
}
