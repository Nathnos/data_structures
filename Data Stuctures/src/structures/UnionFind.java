package structures;

/*
 * Abstraction : each data element has to be associated with a number before feeding him into the UnionFind structure
 * This structure will tell you if two elements belong to same same class. You can join classes and add elements.
 * You need to initialize before making an union. 
 *
 * Useful structure for connectivity problems
 */

public class UnionFind {
	private static final int INITIAL_LENGTH = 8;
	protected int[] parent;
	private int[] rank;
	private int len = 0;

	public UnionFind(int length) {
		parent = new int[length];
		rank = new int[length];
		for(int i = 0; i<length; i++)
			parent[i] = -1;
	}

	public UnionFind() {
		this(INITIAL_LENGTH);
	}

	public int len() {
		return len;
	}

	public boolean isEmpty() {
		return len() > 0;
	}

	public int partent_len() {
		return parent.length;
	}

	public void init(int x) { //Θ(1) amortized
		if (x >= parent.length) { //Need to enlarge
			int[] new_parent = new int[2*x];
			int[] new_rank = new int[2*x];
			for(int i = 0; i<len; i++) {
				new_parent[i] = parent[i];
				new_rank[i] = rank[i];
			}
			for(int i = len; i<2*x; i++)
				new_parent[i] = -1; //Set uninitialized
			parent = new_parent;
			rank = new_rank;
		}
		if (parent[x] != -1)
			return; //Already been initialized
		parent[x] = x;
		rank[x] = 0;
		len = Math.max(len+1, x);
	}

	public int find(int x) { //Almost Θ(1) amortized
		//Find the canonical element (and its rank)
		//Compress the path doing so.
		int y = parent[x];
		if(x != y) { //If it's not the canonical element, do recursion
			parent[x] = find(y);
			y = parent[x];
		}
		return y;
	}

	private void join(int p, int q) { //Θ(n)
		//Join two canonical elements
		if (rank[q] < rank[p]) { //To make rank[p] <= rank[q]
			int temp = q;
			q = p;
			p = temp;
		}
		else if (rank[q] == rank[p])
			rank[q] += 1;
		parent[p] = q;
	}

	public void union(int x, int y) {
		//Connect two elements
		int p = find(x);
		int q = find(y);
		if (p != q) //If they're not part of the same group
			join(p, q);
	}

	//Not very useful
	public String toString() {
		String s = "[(" + 0 + ":" + parent[0] + ")";
		for (int i = 1; i < parent.length; i++) {
			if (parent[i] != -1)
				s += " ; (" + i + ":" + parent[i] + ")";
		}
		s += "]";
		return s;
	}

}
