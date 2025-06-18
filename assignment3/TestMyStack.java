// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

import java.util.Scanner;



public class TestMyStack {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--------MAIN MENU-------");
            System.out.println("1 – Push element");
            System.out.println("2 – Pop element");
            System.out.println("3 – Get top element");
            System.out.println("4 – Get stack size");
            System.out.println("5 – Is empty stack?");
            System.out.println("6 – Print stack");
            System.out.println("7 – Exit program");
            System.out.print("\nEnter option number: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int value = scanner.nextInt();
                    System.out.println("Before push:");
                    stack.printStack();
                    stack.push(value);
                    System.out.println("After push:");
                    stack.printStack();
                    break;

                case 2:
                    System.out.println("Before pop:");
                    stack.printStack();
                    Integer popped = stack.pop();
                    System.out.println("Popped: " + popped);
                    System.out.println("After pop:");
                    stack.printStack();
                    break;

                case 3:
                    System.out.println("Before top:");
                    stack.printStack();
                    System.out.println("Top element: " + stack.top());
                    break;

                case 4:
                    System.out.println("Before size:");
                    stack.printStack();
                    System.out.println("Stack size: " + stack.size());
                    break;

                case 5:
                    System.out.println("Before isEmpty:");
                    stack.printStack();
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 6:
                    stack.printStack();
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 7);

        scanner.close();
    }
}