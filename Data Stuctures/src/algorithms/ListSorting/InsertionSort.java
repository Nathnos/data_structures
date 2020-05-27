package algorithms.ListSorting;

import java.util.ArrayList;

/*
 * A tool class for InsertionSort Algorithm.
 * 
 * Lists can be ArrayList or regular java arrays. Returns the list type of the input.
 */


public class InsertionSort {
	private InsertionSort() {}

	/*
	 * ArrayList version :
	 */

	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> array, boolean ascending) {
		int comparison = ascending ? 1:-1;
		return sort(array, comparison, 0, array.size());
	}
	
	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> array, int comparison, int l, int r) {
		for(int i = l+1; i<r; i++) {
			E x = array.get(i);
			int j = i;
			while(j>l && array.get(j-1).compareTo(x) * comparison > 0) {
				array.set(j, array.get(j-1));
				j--;
			}
			array.set(j, x);
		}
		return array;
	}
	
	
	public static <E extends Comparable<E>> E[] sort(E[] array, boolean ascending) {
		int comparison = ascending ? 1:-1;
		return sort(array, comparison, 0, array.length);
	}
	
	public static <E extends Comparable<E>> E[] sort(E[] array, int comparison, int l, int r) {
		for(int i = l; i<r; i++) {
			E x = array[i];
			int j = i;
			while(j>l && array[j-1].compareTo(x) * comparison > 0) {
				array[j] =  array[j-1];
				j--;
			}
			array[j] = x;
		}
		return array;
	}
}