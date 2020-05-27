package algorithms.ListSorting;

import java.util.ArrayList;
import structures.PQ;

/*
 * A tool class for QuickSort Algorithm.
 * 
 * Lists can be ArrayList or regular java arrays. Returns the list type of the input.
 */

public class HeapSort {
	private HeapSort() {}
	
	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> array, boolean ascending) {
		return PQ.heapSort(array, ascending);
	}
	
	public static <E extends Comparable<E>> ArrayList<E> sort(PQ<E> pq, boolean ascending) {
		return PQ.heapSort(pq, ascending);
	}
	
	public static <E extends Comparable<E>> ArrayList<E> sort(E[] array, boolean ascending) {
		ArrayList<E> arrayList = new ArrayList<E>();
		for(E elem : array)
			arrayList.add(elem);
		return PQ.heapSort(arrayList, ascending);
	}

}
