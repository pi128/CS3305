// Name: James Widner
// Class: CS3305/W01
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #6
// IDE Name: VSC



import java.util.Scanner;

/**
 * Combines functionality from TestBST and TestBSTDelete.
 * Implements a menu to allow the user to interactively manage a BST of integers or strings.
 */
public class MyTestBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isInteger = true;
        boolean treeChosen = false;

        BST<Integer> intTree = new BST<>();
        BST<String> stringTree = new BST<>();

        do {
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("0. Enter Tree Data Type (integer or string)");
            System.out.println("1. Insert Data Element");
            System.out.println("2. Delete Data Element");
            System.out.println("3. Search for Data Element");
            System.out.println("4. Print Tree Size");
            System.out.println("5. Path from Root to Data Element");
            System.out.println("6. Check if Empty Tree");
            System.out.println("7. Print Preorder Traversal");
            System.out.println("8. Print Inorder Traversal");
            System.out.println("9. Print Postorder Traversal");
            System.out.println("10. Exit program");
            System.out.print("Enter option number: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Force user to choose tree type first
            if (option == 0) {
                System.out.print("Enter tree data type (integer/string): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("integer")) {
                    isInteger = true;
                    treeChosen = true;
                } else if (input.equalsIgnoreCase("string")) {
                    isInteger = false;
                    treeChosen = true;
                } else {
                    System.out.println("Invalid data type. Please enter 'integer' or 'string'.");
                }
                continue;
            }

            if (!treeChosen) {
                System.out.println("Please select the tree data type first (option 0).");
                continue;
            }

            switch (option) {
                case 1: // Insert
                    System.out.print("Enter element to insert: ");
                    if (isInteger)
                        intTree.insert(Integer.parseInt(scanner.nextLine()));
                    else
                        stringTree.insert(scanner.nextLine());
                    break;

                case 2: // Delete
                    System.out.print("Enter element to delete: ");
                    if (isInteger)
                        intTree.delete(Integer.parseInt(scanner.nextLine()));
                    else
                        stringTree.delete(scanner.nextLine());
                    break;

                case 3: // Search
                    System.out.print("Enter element to search: ");
                    if (isInteger)
                        System.out.println("Is in the tree? " + intTree.search(Integer.parseInt(scanner.nextLine())));
                    else
                        System.out.println("Is in the tree? " + stringTree.search(scanner.nextLine()));
                    break;

                case 4: // Size
                    System.out.println("Tree size: " + (isInteger ? intTree.getSize() : stringTree.getSize()));
                    break;

                case 5: // Path
                    System.out.print("Enter element: ");
                    if (isInteger)
                        System.out.println("Path: " + intTree.path(Integer.parseInt(scanner.nextLine())));
                    else
                        System.out.println("Path: " + stringTree.path(scanner.nextLine()));
                    break;

                case 6: // Is Empty
                    System.out.println("Is empty tree? " + (isInteger ? intTree.isEmpty() : stringTree.isEmpty()));
                    break;

                case 7: // Preorder
                    System.out.print("Preorder: ");
                    if (isInteger)
                        intTree.preorder();
                    else
                        stringTree.preorder();
                    System.out.println();
                    break;

                case 8: // Inorder
                    System.out.print("Inorder: ");
                    if (isInteger)
                        intTree.inorder();
                    else
                        stringTree.inorder();
                    System.out.println();
                    break;

                case 9: // Postorder
                    System.out.print("Postorder: ");
                    if (isInteger)
                        intTree.postorder();
                    else
                        stringTree.postorder();
                    System.out.println();
                    break;

                case 10: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 10);

        scanner.close();
    }
}