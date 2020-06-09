package examples;

import structures.HashTable;

public class Hash {
	public static void main(String[] args) {
		HashTable<Integer> ht = new HashTable<Integer>(7, 3);
		ht.add(0, 1);
		ht.add(7, 2);
		ht.add(3, 3);
		ht.add(9, 4);
		ht.add(10, 5);
		System.out.println(ht);
		assert(ht.get(0) == 1);
		assert(ht.get(7) == 2);
		assert(ht.get(3) == 3);
		assert(ht.get(9) == 4);
		assert(ht.get(10) == 5);
	}

}
