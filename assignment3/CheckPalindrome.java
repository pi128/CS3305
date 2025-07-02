// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for user input
        String input = ""; // Variable to store user-entered string
        int choice; // Variable to store user's menu choice

        // Do-while loop to display the menu until user chooses to exit
        do {
            // Display the menu
            System.out.println("\n-----------------MAIN MENU----------------");
            System.out.println("1 - Read input string");
            System.out.println("2 - Check palindrome and display output");
            System.out.println("3 - Exit program");
            System.out.print("\nEnter option number: ");

            // Read user’s choice
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after nextInt()

            // Handle user choice using switch-case
            switch (choice) {
                case 1:
                    // Case 1: Read a new string from the user
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine(); // Store the input string
                    break;

                case 2:
                    // Case 2: Check if the string is a palindrome

                    MyStack<Character> stack = new MyStack<>(); // Create a stack to hold characters

                    // Clean the input: remove non-alphabetic characters and convert to lowercase
                    String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Push each character of the cleaned string onto the stack
                    for (char ch : cleaned.toCharArray()) {
                        stack.push(ch);
                    }

                    // Pop characters from the stack to build the reversed string
                    StringBuilder reversed = new StringBuilder();
                    while (!stack.isEmpty()) {
                        reversed.append(stack.pop());
                    }

                    // Output the original string
                    System.out.println("Entered String:   " + input);

                    // Use an if-else statement instead of the ternary operator
                    if (cleaned.equals(reversed.toString())) {
                        System.out.println("Judgment:         Palindrome");
                    } else {
                        System.out.println("Judgment:         Not Palindrome");
                    }

                    break;

                case 3:
                    // Case 3: Exit the program
                    System.out.println("Exiting program.");
                    scanner.close();
                    break;

                default:
                    // If input is not 1, 2, or 3, display an error
                    System.out.println("Invalid option.");
            }

        } while (choice != 3); // Continue looping until user selects "Exit"

    }
}