// Name: James Widner
// Class: CS3305/section
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #7
// IDE Name: VSC

package assignment7;

import java.util.Scanner;

/**
 * This program implements and compares different hash functions using a fixed set of 50 integer keys.
 * The hash table uses open addressing techniques (Linear, Quadratic, Double Hashing) for collision resolution.
 * The user can select a hashing strategy from a menu and view the resulting hash table and probe counts.
 */
public class HashFunctions {

    // Constant table size
    static final int TABLE_SIZE = 50;

    // Fixed array of 50 keys to be hashed — MUST remain unchanged and in this order
    static final int[] keys = {
        1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
        5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
        5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
        5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
        5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523
    };

    /**
     * Main method: Displays the user menu and calls the selected hash function.
     * Repeats until the user chooses to exit.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\n\n-----MAIN MENU--------------------------------------");
            System.out.println("1. Run HF1 (Division method with Linear Probing)");
            System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3. Run HF3 (Division method with Double Hashing)");
            System.out.println("4. Run HF4 (Student Designed HF)");
            System.out.println("5. Exit program");
            System.out.print("Enter option number: ");
            choice = scanner.nextInt();

            // Initialize a fresh hash table: 2 columns, 50 rows
            int[][] table = new int[TABLE_SIZE][2];
            for (int i = 0; i < TABLE_SIZE; i++) table[i][0] = -1; // Set all entries as empty

            switch (choice) {
                case 1: HF1(table); break;
                case 2: HF2(table); break;
                case 3: HF3(table); break;
                case 4: HF4(table); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    /**
     * HF1 — Implements Division method with Linear Probing.
     * If a collision occurs, the index is incremented by 1 until an empty slot is found.
     * @param table The 2D hash table to populate
     */
    public static void HF1(int[][] table) {
        for (int key : keys) {
            int hash = key % TABLE_SIZE;
            int probes = 0;

            // Linear probing: increment by 1 until an empty cell is found
            while (table[hash][0] != -1) {
                hash = (hash + 1) % TABLE_SIZE;
                probes++;
            }

            table[hash][0] = key;    // Store the key
            table[hash][1] = probes; // Store number of probes taken
        }

        printTable(table, "HF1");
    }

    /**
     * HF2 — Implements Division method with Quadratic Probing.
     * Resolves collisions using the formula: hash + j^2
     * @param table The 2D hash table to populate
     */
    public static void HF2(int[][] table) {
        for (int key : keys) {
            int hash = key % TABLE_SIZE;
            int j = 0, probes = 0;
            int newHash = hash;

            // Quadratic probing: newIndex = hash + j^2
            while (table[newHash][0] != -1) {
                j++;
                newHash = (hash + j * j) % TABLE_SIZE;
                probes++;
            }

            table[newHash][0] = key;
            table[newHash][1] = probes;
        }

        printTable(table, "HF2");
    }

    /**
     * HF3 — Implements Division method with Double Hashing.
     * Uses a secondary hash: H2(key) = 30 - key % 25
     * Limit is set to 50 attempts to avoid infinite loops.
     * @param table The 2D hash table to populate
     */
    public static void HF3(int[][] table) {
        for (int key : keys) {
            int h1 = key % TABLE_SIZE;
            int h2 = 30 - (key % 25);  // Secondary hash
            int probes = 0;
            boolean stored = false;

            // Try up to 50 attempts
            for (int j = 0; j < TABLE_SIZE; j++) {
                int hash = (h1 + j * h2) % TABLE_SIZE;

                if (table[hash][0] == -1) {
                    table[hash][0] = key;
                    table[hash][1] = probes;
                    stored = true;
                    break;
                }

                probes++;
            }

            // Print error if unable to insert key
            if (!stored) {
                System.out.println("Unable to hash key " + key + " to the table");
            }
        }

        printTable(table, "HF3");
    }

    /**
     * HF4 — Student-designed hash function.
     * Uses Multiplicative Hashing (Knuth’s method) with Linear Probing for collision resolution.
     * Goal: < 80 total probes and ≥ 90% key insertion success.
     * @param table The 2D hash table to populate
     */
    public static void HF4(int[][] table) {
        double A = 0.6180339887;  // Fractional constant based on golden ratio
        for (int key : keys) {
            // Multiplicative hash function: floor(m * ((key * A) mod 1))
            int hash = (int)(TABLE_SIZE * ((key * A) % 1));
            int probes = 0;

            // Linear probing fallback
            while (table[hash][0] != -1 && probes < TABLE_SIZE) {
                hash = (hash + 1) % TABLE_SIZE;
                probes++;
            }

            if (probes < TABLE_SIZE) {
                table[hash][0] = key;
                table[hash][1] = probes;
            } else {
                System.out.println("Unable to hash key " + key + " to the table");
            }
        }

        printTable(table, "HF4");
    }

    /**
     * Prints the contents of the hash table and the total sum of probe values.
     * Each row shows the index, stored key, and probe count.
     * @param table The filled hash table
     * @param label The label of the hashing function used
     */
    public static void printTable(int[][] table, String label) {
        System.out.println("\nHash table resulted from " + label + ":");
        System.out.println("Index\tKey\tprobes");
        System.out.println("------------------------");

        int sum = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i][0] != -1) {
                System.out.printf("%d\t%d\t%d\n", i, table[i][0], table[i][1]);
                sum += table[i][1];
            }
        }

        System.out.println("------------------------");
        System.out.println("Sum of probe values = " + sum + " probes.\n");
    }
}

/* 
 early morning and senior project 
 
 */