// Name:    James Widner
// Class:   CS3305/W03 
// Term:    Spring 2025 
// Instructor:   Prof. Wang 
// Assignment:   #6 
// IDE Name:     VSC

package assignment5; 

// Class Heap.java 
// Textbook - Listing 23.9, Page 878

public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args) {
    
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
      
      System.out.print("Original List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   
         
   }
}
