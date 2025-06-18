// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<String> stack = new MyStack<>();
        String input = "";
        int choice;

        do {
            System.out.println("\n-----------------MAIN MENU---------------");
            System.out.println("1 – Read input string of words");
            System.out.println("2 – Reverse string and display outputs");
            System.out.println("3 – Exit program");
            System.out.print("\nEnter option number: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string of words: ");
                    input = scanner.nextLine();
                    break;

                case 2:
                    for (String word : input.split(" ")) {
                        stack.push(word);
                    }
                    System.out.println("Entered string:    " + input);
                    System.out.print("Reversed String:   ");
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println();
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