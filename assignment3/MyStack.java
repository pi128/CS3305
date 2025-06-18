// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA



public class MyStack<E> {

    // Inner class representing a node in the linked list
    private class Node {
        E data;         // The actual data stored in the node
        Node next;      // Reference to the next node

        // Constructor to create a new node with given data
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // Points to the top node of the stack
    private int size;  // Keeps track of the number of elements in the stack

    // Constructor to create an empty stack
    public MyStack() {
        top = null;     // No nodes yet
        size = 0;       // Size is zero
    }

    // Push a new element onto the top of the stack
    public void push(E element) {
        Node newNode = new Node(element); // Create a new node with the data
        newNode.next = top;               // Set new node to point to the current top
        top = newNode;                    // Make the new node the new top
        size++;                           // Increase stack size
    }

    // Pop (remove) the top element from the stack and return its value
    public E pop() {
        if (isEmpty()) return null;       // Return null if stack is empty
        E popped = top.data;              // Get data from the top node
        top = top.next;                   // Move top to the next node down
        size--;                           // Decrease stack size
        return popped;                    // Return the popped data
    }

    // Peek at the top element without removing it
    public E top() {
        return isEmpty() ? null : top.data; // Return top data or null if empty
    }

    // Return the current size of the stack
    public int size() {
        return size;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null; // If top is null, stack is empty
    }

    // Print the contents of the stack from top to bottom
    public void printStack() {
        Node current = top;               // Start from the top of the stack
        System.out.print("Stack: ");
        while (current != null) {         // While there are more nodes
            System.out.print(current.data + " "); // Print data
            current = current.next;       // Move to the next node down
        }
        System.out.println();             // New line after printing stack
    }
}