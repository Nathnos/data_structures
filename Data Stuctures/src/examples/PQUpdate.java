package examples;

import structures.queues.PQ;

public class PQUpdate {
	public static void main(String[] args) {
		PQ<Int> queue = new PQ<Int>(false);
		Int i = new Int(25);
		queue.insert(new Int(3));
		queue.insert(new Int(7));
		queue.insert(new Int(7));
		queue.insert(i);
		queue.insert(new Int(2));
		queue.insert(new Int(-2));
		i.value = 5;
		queue.update(i);
		while(!queue.isEmpty())
			System.out.print(queue.delete() + " ; ");
		System.out.println();
	}
	
	private static class Int implements Comparable<Int> {
		public int value;
		public Int(int value) {
			this.value = value;
		}
		@Override
		public int compareTo(Int a) {
			if (value > a.value)
				return 1;
			else if(value < a.value)
				return -1;
			return 0;
		}
		public String toString() {
			return value + "";
		}
	  }
}
