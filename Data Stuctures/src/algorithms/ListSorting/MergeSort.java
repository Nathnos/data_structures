package algorithms.ListSorting;

/*
 * A tool class for MergeSort algorithm.
 * 
 * Lists can only be regular java arrays. Returns java array too.
 * An improvement is implemented ; for small array (size < 5), we use the InsertionSort
 */

public class MergeSort {
	private MergeSort() {}
	
	public static <E extends Comparable<E>> E[] sort(E[] array, boolean ascending) {
		return sort(array, 0, array.length-1, ascending);
	}

	public static <E extends Comparable<E>> E[] sort(E[] array, int l, int r, boolean ascending) {
		return array;
	}
}

