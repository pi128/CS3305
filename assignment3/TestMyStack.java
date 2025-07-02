// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

import java.util.Scanner; // Import Scanner for user input

public class TestMyStack {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(); // Create a stack to store integers
        Scanner scanner = new Scanner(System.in); // Scanner object for reading input
        int choice; // Variable to store menu option

        // Display menu until user chooses to exit
        do {
            // Show the main menu
            System.out.println("\n--------MAIN MENU-------");
            System.out.println("1 - Push element");
            System.out.println("2 - Pop element");
            System.out.println("3 - Get top element");
            System.out.println("4 - Get stack size");
            System.out.println("5 - Is empty stack?");
            System.out.println("6 - Print stack");
            System.out.println("7 - Exit program");
            System.out.print("\nEnter option number: ");

            choice = scanner.nextInt(); // Read the user's choice

            switch (choice) {
                case 1:
                    // Push an element onto the stack
                    System.out.print("Enter element to push: ");
                    int value = scanner.nextInt(); // Get the value from user
                    System.out.println("Before push:");
                    stack.printStack(); // Show stack before push
                    stack.push(value);  // Push value onto stack
                    System.out.println("After push:");
                    stack.printStack(); // Show stack after push
                    break;

                case 2:
                    // Pop the top element from the stack
                    System.out.println("Before pop:");
                    stack.printStack(); // Show stack before pop
                    Integer popped = stack.pop(); // Remove top item
                    System.out.println("Popped: " + popped); // Show popped item
                    System.out.println("After pop:");
                    stack.printStack(); // Show stack after pop
                    break;

                case 3:
                    // View the top element without removing it
                    System.out.println("Before top:");
                    stack.printStack(); // Show current stack
                    System.out.println("Top element: " + stack.top()); // Show top element
                    break;

                case 4:
                    // Display the size of the stack
                    System.out.println("Before size:");
                    stack.printStack(); // Show current stack
                    System.out.println("Stack size: " + stack.size()); // Show number of elements
                    break;

                case 5:
                    // Check if the stack is empty
                    System.out.println("Before isEmpty:");
                    stack.printStack(); // Show current stack
                    System.out.println("Is stack empty? " + stack.isEmpty()); // Check and print
                    break;

                case 6:
                    // Print all elements in the stack
                    stack.printStack();
                    break;

                case 7:
                    // Exit the program
                    System.out.println("Exiting program.");
                    break;

                default:
                    // Handle any invalid input
                    System.out.println("Invalid option.");
            }

        } while (choice != 7); // Loop until user chooses to exit

        scanner.close(); // Close the scanner to avoid resource leak
    }
}