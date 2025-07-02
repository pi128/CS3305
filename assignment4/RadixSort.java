// Name: James Widner
// Class: CS3305/section#
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #4
// IDE Name: VSC

package assignment4;

import java.util.Scanner;

/**
 * This class implements the Radix Sort algorithm using an array of
 * Queue<Integer> objects (Q0 through Q9) and provides a menu interface
 * to read input, sort values, and print output.
 */
public class RadixSort {

    /**
     * Counts how many digits are in a given positive integer.
     * @param number the number to count digits of
     * @return the number of digits
     */
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    /**
     * Extracts a specific digit (from right to left, starting at 0).
     * For example: extractDigit(213, 0) = 3, extractDigit(213, 1) = 1
     * @param number the number to extract from
     * @param position digit position (0 = least significant)
     * @return the digit at the specified position
     */
    public static int extractDigit(int number, int position) {
        return (number / (int)Math.pow(10, position)) % 10;
    }

    /**
     * Sorts an array of positive integers using the Radix Sort algorithm.
     * @param arr the array to sort
     */
    public static void radixSort(int[] arr) {
        // Find maximum number of digits in any element
        int maxDigits = 0;
        for (int num : arr) {
            maxDigits = Math.max(maxDigits, countDigits(num));
        }

        // Create array of 10 queues for digits 0–9
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Queue<>();
        }

        // Perform sorting for each digit position
        for (int pos = 0; pos < maxDigits; pos++) {
            // Distribute elements into queues based on current digit
            for (int num : arr) {
                int digit = extractDigit(num, pos);
                buckets[digit].enqueue(num);
            }

            // Collect elements back into original array
            int index = 0;
            for (int i = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    arr[index++] = buckets[i].dequeue();
                }
            }
        }
    }

    /**
     * Main method: Provides user menu for reading input and executing radix sort.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = null;       // Array to hold input values
        int size = 0;              // Size of input array
        int option;                // Menu selection
        String original = "";      // Stores original values for display

        // Menu loop
        do {
            System.out.println("\n\n---------------MAIN MENU---------------");
            System.out.println("1 - Read array size");
            System.out.println("2 - Read array values");
            System.out.println("3 - Run Radix Sort and print outputs");
            System.out.println("4 - Exit program\n");
            System.out.print("Enter option number: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Read size of input array
                    System.out.print("Enter array size: ");
                    size = scanner.nextInt();
                    if (size <= 0) {
                        System.out.println("Size must be positive.");
                    } else {
                        inputs = new int[size];
                        System.out.println("Size set to " + size + ".");
                    }
                    break;

                case 2:
                    // Read values into array
                    if (inputs == null) {
                        System.out.println("Please select option 1 first.");
                        break;
                    }
                    System.out.println("Enter " + size + " positive integers:");
                    original = "";
                    for (int i = 0; i < size; i++) {
                        int val = scanner.nextInt();
                        if (val < 0) {
                            System.out.println("Only positive integers allowed.");
                            i--; // retry same index
                            continue;
                        }
                        inputs[i] = val;
                        original += val + (i < size - 1 ? ", " : "");
                    }
                    break;

                case 3:
                    // Run Radix Sort and display results
                    if (inputs == null || original.isEmpty()) {
                        System.out.println("Please complete options 1 and 2 first.");
                        break;
                    }

                    System.out.println("Array values before sorting:    " + original);
                    radixSort(inputs);

                    // Build sorted string to print
                    System.out.print("Array values after sorting:     ");
                    for (int i = 0; i < inputs.length; i++) {
                        System.out.print(inputs[i]);
                        if (i < inputs.length - 1) System.out.print(", ");
                        else System.out.println();
                    }
                    break;

                case 4:
                    // Exit message
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1–4.");
            }

        } while (option != 4); // Loop until exit

        scanner.close(); // Close scanner
    }
}