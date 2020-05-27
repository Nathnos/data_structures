package examples;

import java.util.ArrayList;
import algorithms.ListSorting.*;

public class ListSorting {
  public static void main(String[] args) {
	ArrayList<Integer> array = new ArrayList<Integer>();
	array.add(9);
	array.add(4);
	array.add(1);
	array.add(32);
	array.add(7);
	array.add(23);
	boolean ascending = true;
    System.out.println("Array : " + array);
    System.out.println("ArrayList :");
    System.out.println(InsertionSort.sort(array, ascending));
    System.out.println(HeapSort.sort(array, ascending));
    System.out.println(QuickSort.sort(array, ascending));
    
    System.out.println("\nJava array :");
    Integer[] array2 = {9, 4, 1, 32, 7, 23};
    print_arr(InsertionSort.sort(array2, ascending));
    System.out.println(HeapSort.sort(array2, ascending));
    print_arr(QuickSort.sort(array2, ascending));
    
    
    System.out.println("\nBig test :");
    Integer[] big_arr = {9, 4, 1, 32, 7, 23, 17, 29, -24, 42, 7, 18, 21, 0, 4, 1, 12, 14, 27, 91, -200};
    print_arr(QuickSort.sort(big_arr, ascending));
    System.out.println(HeapSort.sort(big_arr, ascending));
  }
  
  private static void print_arr(Integer[] array) {
	  for(Integer i : array) {
		  System.out.print(i + ";");
	  }
	  System.out.println();
	  return;
  }
}
