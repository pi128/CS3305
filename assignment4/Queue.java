// Name: James Widner
// Class: CS3305/section#
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #4
// IDE Name: VSC
package assignment4;

public class Queue<E> {

    /**
     * Inner class Node represents each element in the linked list.
     */
    private static class Node<E> {
        E data;          // Stores the element
        Node<E> next;    // Reference to the next node

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;  // Front of the queue
    private Node<E> rear;   // Rear of the queue
    private int size;       // Tracks the number of elements

    /**
     * Constructor initializes an empty queue.
     */
    public Queue() {
        front = rear = null;
        size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param e the element to be added
     */
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e); // Create new node with the given data

        // If queue is empty, front and rear both point to new node
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode; // Link new node at the end of queue
            rear = newNode;      // Move rear to new node
        }
        size++; // Increase size count
    }

    /**
     * Removes and returns the front element of the queue.
     * @return the dequeued element or null if queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E value = front.data; // Store front data
        front = front.next;   // Move front to next node
        size--;               // Decrease size

        // If queue becomes empty, set rear to null as well
        if (front == null) {
            rear = null;
        }

        return value;
    }

    /**
     * Returns the front element without removing it.
     * @return front element or null if queue is empty
     */
    public E front() {
        return isEmpty() ? null : front.data;
    }

    /**
     * Returns the number of elements in the queue.
     * @return queue size
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the queue.
     * @return string of all elements from front to rear
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = front;

        // Traverse the queue and append elements to the string builder
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }

        return sb.toString().trim();
    }
}