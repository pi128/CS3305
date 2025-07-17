// Name: James Widner
// Class: CS3305/W01
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #6
// IDE Name: VSC



import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * A program that reads a string of words from the user,
 * stores them in a BST, and removes duplicates.
 * The user can view the processed text using an inorder traversal.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = ""; // Stores user input string
        BST<String> tree = new BST<>(); // BST to hold unique words

        int option;
        do {
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1. Read input string");
            System.out.println("2. Remove duplicates and display outputs");
            System.out.println("3. Exit program");
            System.out.print("Enter option number: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    // Get the input text from the user
                    System.out.println("Enter input text:");
                    input = scanner.nextLine();
                    break;

                case 2:
                    // Validate that input is available
                    if (input.isEmpty()) {
                        System.out.println("No input string found. Please enter input string first.");
                        break;
                    }

                    // Reset the tree before inserting new words
                    tree = new BST<>();
                    StringTokenizer tokenizer = new StringTokenizer(input);

                    // Insert each word into the BST (duplicates ignored)
                    while (tokenizer.hasMoreTokens()) {
                        tree.insert(tokenizer.nextToken());
                    }

                    // Display results
                    System.out.println("Original Text: ");
                    System.out.println(input);
                    System.out.println("Processed Text: ");
                    tree.inorder(); // Inorder traversal gives sorted, deduplicated output
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 3);

        scanner.close();
    }
}