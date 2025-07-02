// Name: James Widner
// Class: CS3305/section#
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #4
// IDE Name: VSC

package assignment4;

import java.util.Scanner;

/**
 * This class tests the generic Queue class using integer values.
 * It provides a menu for users to interactively perform queue operations:
 * enqueue, dequeue, get front, check size, check if empty, and print the queue.
 */
public class TestQueue {

    /**
     * Main method: Runs the interactive test program for the Queue class.
     * Provides a menu and executes user-selected operations until the user exits.
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(); // Create a queue of integers
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int option; // Stores user's menu selection

        // Start menu loop
        do {
            // Display menu
            System.out.println("\n\n--------MAIN MENU--------");
            System.out.println("1 - Enqueue element");
            System.out.println("2 - Dequeue element");
            System.out.println("3 - Get front element");
            System.out.println("4 - get queue size");
            System.out.println("5 - Is Empty queue?");
            System.out.println("6 - Print queue");
            System.out.println("7 - Exit program\n");
            System.out.print("Enter option number: ");

            // Read user selection
            option = scanner.nextInt();

            // Process selection using switch statement
            switch (option) {
                case 1:
                    // Enqueue new element
                    System.out.print("Enter an integer to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    System.out.println("Element " + value + " enqueued.");
                    break;

                case 2:
                    // Dequeue element from queue
                    Integer removed = queue.dequeue();
                    if (removed != null) {
                        System.out.println("Dequeued: " + removed);
                    } else {
                        System.out.println("Empty Stack");
                    }
                    break;

                case 3:
                    // Get the front element
                    Integer front = queue.front();
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    } else {
                        System.out.println("Empty Stack");
                    }
                    break;

                case 4:
                    // Get current size
                    System.out.println("Queue size: " + queue.size());
                    break;

                case 5:
                    // Check if queue is empty
                    System.out.println("Is queue empty? " + queue.isEmpty());
                    break;

                case 6:
                    // Print all elements in queue
                    System.out.println("Queue contents: " + queue.toString());
                    break;

                case 7:
                    // Exit message
                    System.out.println("Exiting...");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please enter 1–7.");
            }

        } while (option != 7); // Exit when user chooses option 7

        scanner.close(); // Close scanner to release resources
    }
}