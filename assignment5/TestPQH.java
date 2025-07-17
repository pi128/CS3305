// Name:    James Widner
// Class:   CS3305/W03 
// Term:    Spring 2025 
// Instructor:   Prof. Wang 
// Assignment:   #6 
// IDE Name:     VSC

package assignment5;    

import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean sent = true;
        boolean queueEntered = false;
        boolean usingInt = false;

        // Declare the queues outside the loop so they persist
        PQ_heap<Integer> intPQ = null;
        PQ_heap<String> stringPQ = null;

        while (sent) {
            System.out.print("""
                ----------------MAIN MENU---------------
            0. Enter Queue Type (integer or string)
            1.  Enqueue Element
            2.  Dequeue Element
            3.  Check is_Full
            4.  Check is_Empty
            5.  Print PQueue Size
            6.  Display Front Element
            7.  Print PQueue Elements
            8.  Exit program

               Enter option number: """);

            int resp = scan.nextInt();
            scan.nextLine(); // consume newline

            if (resp != 0 && !queueEntered) {
                System.out.println("Please enter the queue type first (option 0).\n");
                continue;
            }

            switch (resp) {
                case 0 -> {
                    System.out.print("Do you wish to use an integer or string queue? (i/s): ");
                    String type = scan.nextLine();

                    if (type.equalsIgnoreCase("i")) {
                        intPQ = new PQ_heap<>();
                        usingInt = true;
                        queueEntered = true;
                        System.out.println("Integer Priority Queue created.");
                    } else if (type.equalsIgnoreCase("s")) {
                        stringPQ = new PQ_heap<>();
                        usingInt = false;
                        queueEntered = true;
                        System.out.println("String Priority Queue created.");
                    } else {
                        System.out.println("Invalid type. Please enter 'i' or 's'.");
                    }
                }
                // Enqueue an element into the queue
                case 1 -> {
                    if(usingInt){
                        System.out.print("Enter an integer to enqueue: ");
                        int value = scan.nextInt();
                        intPQ.enqueue(value);
                        System.out.println("Enqueued: " + value);
                    } else {
                        System.out.print("Enter a string to enqueue: ");
                        String value = scan.nextLine();
                        stringPQ.enqueue(value);
                        System.out.println("Enqueued: " + value);
                    }
                }
                // Dequeue an element from the queue
                case 2 -> {
                        System.out.println("Dequeued Element:");
                        if (usingInt) {
                            System.out.println(intPQ.dequeue());
                        } else {
                            System.out.println(stringPQ.dequeue());
                        }
                }
                // Check if the queue is full
                case 3 -> {
                    if (usingInt) {
                        System.out.println("Is Integer Queue Full? " + intPQ.is_full());
                    } else {
                        System.out.println("Is String Queue Full? " + stringPQ.is_full());
                    }
                }
                // Check if the queue is empty
                case 4 -> {
                    if (usingInt) {
                        System.out.println("Is Integer Queue Empty? " + intPQ.is_empty());
                    } else {
                        System.out.println("Is String Queue Empty? " + stringPQ.is_empty());
                    }
                }
                // Print the size of the queue
                case 5 -> {
                    if (usingInt) {
                        System.out.println("Integer Queue Size: " + intPQ.size());
                    } else {
                        System.out.println("String Queue Size: " + stringPQ.size());
                    }
                }
                // Display the front element of the queue
                case 6 -> {
                    if (usingInt) {
                        System.out.println("Front Element of Integer Queue: " + intPQ.front());
                    } else {
                        System.out.println("Front Element of String Queue: " + stringPQ.front());
                    }
                }
                // Print the elements in the queue
                case 7 -> {
                    if (usingInt) {
                        System.out.println("Integer Queue Elements:");
                        intPQ.printHeapLevels();
                    } else {
                        System.out.println("String Queue Elements:");
                        stringPQ.printHeapLevels();
                    }
                }
                // Exit case
                case 8 -> {
                    System.out.println("Exiting program.");
                    sent = false;
                }
                

                

                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            // Print a new line for better readability
            System.out.println();
        }
    }
}