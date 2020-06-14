package structures;

import java.util.Arrays;

/*
 * Hash function : h(k) = k mod M
 * Uses open adressing to resolve collision
 */

public class HashTable<E> {
	private static final int M_DEF = 1583, MP_DEF = 557; //Prime number, far away from 10^j and 2^j
	private final int M, MP;
	private Array<E> table;
	private Array<Integer> keys;
	
	@SuppressWarnings("hiding")
	private class Array<E> {
		private Object[] arr;
		private int length;

		public Array(int length) {
			arr = new Object[length];
			this.length = length;
		}

		E get(int i) {
			if(i >= length)
				return null;
			@SuppressWarnings("unchecked")
			final E e = (E)arr[i];
			return e;
		}

		void set(int i, E e) {
			if(i >= length) {
				int old_len = length;
				length = i*2;
				Object[] new_arr = new Object[length];
				for(int k = 0; k < old_len; k++) {
					new_arr[k] = arr[k];
				}
				arr = new_arr;
			}
			arr[i] = e;
		}

		@Override
		public String toString() {
			return Arrays.toString(arr);
		}
	}

	
	public HashTable() {
		this(M_DEF, MP_DEF);
	}
	
	public HashTable(int M) {
		this(M, MP_DEF);
	}
	public HashTable(int M, int MP) {
		this.M = M;
		this.MP = MP;
		table = new Array<E>(M);
		keys = new Array<Integer>(M);
	}
	
	private int hash(int key) {
		return key % M;
	}
	
	private int pooling_hash(int key) {
		return key % MP;
	}
	
	public void add(int key, E data) {
		if(data == null) {
			System.err.println("table can't be empty. Insertion into HashTable failed.");
			return;
		}
		int i = get_i(key);
		table.set(i, data);
		keys.set(i, key);
	}
	

	public E get(int key) {
		int i = find_i(key);
		if(i == -1)
			return null;
		return table.get(i);
	}
	
	private int get_i(int key) {
		int i = hash(key);
		if(keys.get(i) != null)
			i = pooling(key, i);
		return i;
	}
	
	private int pooling(int key, int hk) {
		int c = pooling_hash(key+1);
		int i = 1;
		while(keys.get(hk + i*c) != null)
			i ++;
		return hk + i*c;
	}
	
	private int find_i(int key) {
		int hk = hash(key);
		int c = pooling_hash(key+1);
		while(keys.get(hk) != key) {
			if(keys.get(hk) == null)
				return -1;
			hk += c;
		}
		return hk;
	}
	
	public String toString() {
		return table.toString();
	}
	
}
