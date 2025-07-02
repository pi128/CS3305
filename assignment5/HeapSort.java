// Name:    James Widner
// Class:   CS3305/W03 
// Term:    Spring 2025 
// Instructor:   Prof. Wang 
// Assignment:   #6 
// IDE Name:     VSC

package assignment5;

// Class Heap.java 
// Textbook - Listing 23.9, Page 878

public class HeapSort {
   /** Heap sort method */
   public static <E extends Comparable<E>> void heapSort(E[] list) {
      // Create a Heap of integers
      Heap<E> heap = new Heap<E>();
   
      // Add elements to the heap
      for (int i = 0; i < list.length; i++)
         heap.add(list[i]);
   
      // Remove elements from the heap
      for (int i = list.length - 1; i >= 0; i--)
         list[i] = heap.remove();
   }
   
}
