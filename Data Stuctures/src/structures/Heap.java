package structures;

/*
 * A generic N-Heap.
 */

import java.util.ArrayList;

public class Heap<T> {
	private final static int INITIAL_SIZE = 10;
	public final int arity; //Max array n-ary
	protected ArrayList<T> array;
	
	public Heap(int arity, int initial_size) {
		array = new ArrayList<T>(initial_size);
		this.arity = arity;
	}
	
	public Heap(int arity) {
		this(arity, INITIAL_SIZE);
	}
	
	public int size() {
		return array.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int getChild(int i, int k) {
		return arity*i+ k + 1;
	}
	
	public T getChildValue(int i, int k) {
		return array.get(getChild(i, k));
	}
	
	public int getParent(int i) {
		if(i == 0)
			return -1;
		return (i-1)/arity;
	}
	
	public T getParentValue(int i) {
		if(i == 0)
			return null;
		return array.get(getParent(i));
	}
	
	public int getArity() {
		return arity;
	}
	
	public String toString() {
		return array.toString();
	}

}
