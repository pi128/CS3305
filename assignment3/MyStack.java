// Name: James Widner
// Class: CS3305/W03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #3
// IDE Name: IntelliJ IDEA

package assignment3;

public class MyStack<E> {

    // Node class definition
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // Top of stack
    private int size;

    // Constructor
    public MyStack() {
        top = null;
        size = 0;
    }

    // Push element onto stack
    public void push(E element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop top element off the stack
    public E pop() {
        if (isEmpty()) return null;
        E popped = top.data;
        top = top.next;
        size--;
        return popped;
    }

    // Peek at top element
    public E top() {
        return isEmpty() ? null : top.data;
    }

    // Stack size
    public int size() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print stack elements from top to bottom
    public void printStack() {
        Node current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}