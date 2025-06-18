// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA



import java.util.Scanner; // Import Scanner for reading user input

public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        MyStack<String> stack = new MyStack<>();  // Create a stack to store words
        String input = "";                        // Variable to store user input
        int choice;                               // Variable for menu option

        // Display menu until user chooses to exit
        do {
            // Print the main menu
            System.out.println("\n-----------------MAIN MENU---------------");
            System.out.println("1 - Read input string of words");
            System.out.println("2 - Reverse string and display outputs");
            System.out.println("3 - Exit program");
            System.out.print("\nEnter option number: ");

            choice = scanner.nextInt(); // Read user’s choice
            scanner.nextLine();         // Clear newline character after nextInt()

            // Perform action based on menu choice
            switch (choice) {
                case 1:
                    // Read input string from user
                    System.out.print("Enter a string of words: ");
                    input = scanner.nextLine(); // Save the entire input line
                    break;

                case 2:
                    // Split the string into words and push each onto the stack
                    for (String word : input.split(" ")) {
                        stack.push(word);
                    }

                    // Display the original input
                    System.out.println("Entered string:    " + input);

                    // Pop and print each word from the stack to reverse the order
                    System.out.print("Reversed String:   ");
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println(); // Move to next line after printing
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting program.");
                    break;

                default:
                    // Handle invalid menu input
                    System.out.println("Invalid option.");
            }
        } while (choice != 3); // Keep looping until user chooses to exit
    }
}