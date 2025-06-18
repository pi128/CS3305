// Name: <your name>
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int choice;

        do {
            System.out.println("\n-----------------MAIN MENU----------------");
            System.out.println("1 – Read input string");
            System.out.println("2 – Check palindrome and display output");
            System.out.println("3 – Exit program");
            System.out.print("\nEnter option number: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    break;

                case 2:
                    MyStack<Character> stack = new MyStack<>();
                    String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    for (char ch : cleaned.toCharArray()) {
                        stack.push(ch);
                    }

                    StringBuilder reversed = new StringBuilder();
                    while (!stack.isEmpty()) {
                        reversed.append(stack.pop());
                    }

                    System.out.println("Entered String:   " + input);
                    System.out.println("Judgment:         " +
                            (cleaned.equals(reversed.toString()) ? "Palindrome" : "Not Palindrome"));
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }
}