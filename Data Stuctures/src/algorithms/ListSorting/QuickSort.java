package algorithms.ListSorting;

import java.util.ArrayList;

/*
 * A tool class for QuickSorti Algorithm.
 * 
 * Lists can be ArrayList or regular java arrays. Returns the list type of the input.
 * An improvement is implemented ; for small array (size < 5), we use the InsertionSort
 */

public class QuickSort {
	private QuickSort() {}

	/*
	 * ArrayList version :
	 */
	
	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> array, boolean ascending) {
		return sort(array, 0, array.size()-1, ascending);
	}
	
	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> array, int l, int r, boolean ascending) {
		int comparison;
		if(ascending)
			comparison = 1;
		else
			comparison = -1;
		quick_sort(array, l, r, comparison);
		return array;
	}
	
	private static <E extends Comparable<E>> void quick_sort(ArrayList<E> array, int l, int r, int comparison) {
		if (r-l < 10) {
			InsertionSort.sort(array, comparison, l, r+1);
			return;
		}
		//Else (with l < r)
		int m = sort_iteration(array, l, r, comparison);
		quick_sort(array, l, m, comparison);
		quick_sort(array, m+1, r, comparison);
	}

	private static <E extends Comparable<E>> int sort_iteration(ArrayList<E> array, int l, int r, int comparison) {
		E elem = array.get(l);
		while(l < r) {
			while (array.get(l).compareTo(elem) * comparison < 0)
				l++;
			while (array.get(r).compareTo(elem) * comparison > 0)
				r--;
			if (l < r) {
				E left_elem = array.get(l);
				array.set(l, array.get(r));
				array.set(r, left_elem);
				l++;
				r--;
			}
		}
		return (l+r)/2;
	}
	
	/*
	 * Regular array version :
	 */
	
	public static <E extends Comparable<E>> E[] sort(E[] array, boolean ascending) {
		return sort(array, 0, array.length-1, ascending);
	}
	
	public static <E extends Comparable<E>> E[] sort(E[] array, int l, int r, boolean ascending) {
		int comparison;
		if(ascending)
			comparison = 1;
		else
			comparison = -1;
		quick_sort(array, l, r, comparison);
		return array;
	}
	
	private static <E extends Comparable<E>> void quick_sort(E[] array, int l, int r, int comparison) {
		if (r-l < 10) {
			InsertionSort.sort(array, comparison, l, r+1);
			return;
		}
		//Else (with l < r)
		int m = sort_iteration(array, l, r, comparison);
		quick_sort(array, l, m, comparison);
		quick_sort(array, m+1, r, comparison);
	}

	private static <E extends Comparable<E>> int sort_iteration(E[] array, int l, int r, int comparison) {
		E elem = array[l];
		while(l < r) {
			while (array[l].compareTo(elem) * comparison < 0)
				l++;
			while (array[r].compareTo(elem) * comparison > 0)
				r--;
			if (l < r) {
				E left_elem = array[l];
				array[l] = array[r];
				array[r] = left_elem;
				l++;
				r--;
			}
		}
		return (l+r)/2;
	}
}
