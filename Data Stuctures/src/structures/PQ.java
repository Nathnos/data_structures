package structures;

import java.util.ArrayList;

/*
 * Priority Queue with no access to the inner ArrayList.
 */

public class PQ<E extends Comparable<E>> extends Heap<E> {
	private static final int INITIAL_SIZE = 10;
	private static final int DEFAULT_ARITY = 8;
	private int comparison;
	
	public PQ(boolean isMax, int arity, int size) {
		super(arity, size);
		if(isMax)
			comparison = 1;
		else
			comparison = -1;
	}
	
	public PQ() {
		this(false, DEFAULT_ARITY, INITIAL_SIZE);
	}
	
	public PQ(boolean isMax) {
		this(isMax, DEFAULT_ARITY, INITIAL_SIZE);
	}
	
	public PQ(boolean isMax, int arity) {
		this(isMax, arity, INITIAL_SIZE);
	}
	
	public PQ(ArrayList<E> array, boolean isMax) {
		this(isMax, DEFAULT_ARITY, INITIAL_SIZE);
		this.array = array;
		heapify(this);
	}
	
	public void insert(E elem) {
		array.add(elem);
		swim(elem, array.size()-1);
	}
	
	public E delete() {
		E r = array.get(0);
		E last = array.remove(array.size()-1);
		if(array.size() > 0)
			sink(last, 0);
		return r;
	}
	
	private void swim(E elem, int position) {
		int p = getParent(position);
		while(p != -1 && array.get(p).compareTo(elem) * comparison < 0) {
			array.set(position, array.get(p));
			position = p;
			p = getParent(position);
		}
		array.set(position, elem);
	}
	
	private void sink(E elem, int position) {
		sink(elem, position, array.size());
	}
	
	private void sink(E elem, int position, int maxSize) {
		int c = extremeChild(position, maxSize);
		while(c != -1 && array.get(c).compareTo(elem) * comparison > 0) {
			array.set(position, array.get(c));
			position = c;
			c = extremeChild(position, maxSize);
		}
		array.set(position, elem);
	}
	
	private int extremeChild(int position, int maxSize) {
		if (getChild(position, 0) >= maxSize)
			return -1;
		int min = getChild(position, 0);
		for(int i = 1; i < arity && getChild(position, i) < maxSize; i++) {
			if(array.get(min).compareTo( array.get(getChild(position, i)) ) * comparison < 0)
				min = getChild(position, i);
		}
		return min;
	}
	
	/*
	 * Algorithms :
	 */
	
	private static <E extends Comparable<E>> void heapify(PQ<E> pq) {
		for(int i = pq.size()/2; i >= 0; i--) {
			pq.sink(pq.array.get(i), i);
		};
	}
	
	public static <E extends Comparable<E>> ArrayList<E> heapSort(ArrayList<E> array, boolean ascending) {
		PQ<E> pq = new PQ<E>(array, ascending); //Does heapify
		int n = pq.size()-1;
		while(n > 0) {
			E last = array.get(n);
			array.set(n, array.get(0));
			array.set(0, last);
			pq.sink(last, 0, n);
			n--;
		}
		return array;
	}
	
	public static <E extends Comparable<E>> ArrayList<E> heapSort(PQ<E> pq, boolean ascending) {
		return heapSort(pq.array, ascending);
	}
	
}