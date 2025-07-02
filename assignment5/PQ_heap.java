// Name:    James Widner
// Class:   CS3305/W03 
// Term:    Spring 2025 
// Instructor:   Prof. Wang 
// Assignment:   #6 
// IDE Name:     VSC

package assignment5;


// Generic code for class PQ_heap for Assignment 7 

public class PQ_heap<E extends Comparable<E>> {
    
    private Heap<E> heap;  // Declare type properly
	private final int CAPACITY = 100;  // Add this at the top of Heap.java

    // Constructor
    public PQ_heap() {
        heap = new Heap<>();  // Initialize it here
    }

	
    // Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {
		return heap.getSize() == 0; 
   }
 
	
  





   // Precondition: priority queue has a maximum size

   	
	
	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {
	return heap.getSize() >= CAPACITY;
   }

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() {
	return heap.peek();
   };

	// return number of elements in the queue
   public int size() {
	return heap.getSize();
   }
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public E dequeue() {
	return heap.remove();

   };

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(E value) {
	if (is_full()) {
		return;	
   		}
   heap.add(value);

	}
	public void printHeapLevels() {
		java.util.ArrayList<E> list = heap.getList();
		int size = heap.getSize();
	
		if (size == 0) {
			System.out.println("Priority Queue is empty.");
			return;
		}
	
		int index = 0;
		int level = 0;
	
		while (index < size) {
			int nodesInLevel = (int) Math.pow(2, level);
			System.out.print("Index " + level + ":  ");
			for (int i = 0; i < nodesInLevel && index < size; i++, index++) {
				System.out.print(list.get(index) + "   ");
			}
			System.out.println();
			level++;
		}
	}

  
}

