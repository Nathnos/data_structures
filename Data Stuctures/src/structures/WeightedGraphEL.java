package structures;

import java.util.ArrayList;
import algorithms.ListSorting.*;

/*
 * Weighted, undirected graphs.
 * 
 * Uses Union-Find and EdgeList.
 * Vertex are represented as integers. 
 * 
 * Implicit edges are no longer sufficient, since they have a weight.
 * Do not add two times the same edge. addEdge won't check if it already exists.
 */

public class WeightedGraphEL {
	private static final int INITIAL_LENGTH = 8;
	private ArrayList<Edge> edgeList;
	private Graph graph;
	
	private static class Edge implements Comparable<Edge> {
		//NB : there is source and destination, still it's undirected.
		int source, destinaiton;
		double weight;
		public Edge(int source, int destinaiton, double weight) {
			this.source = source;
			this.destinaiton = destinaiton;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			if(weight > e.weight)
				return 1;
			if(weight < e.weight)
				return -1;
			return 0;
		}
		public String toString() {
			return "(" + source + ", " + destinaiton + ", " + weight + ")";
		}
	}
	
	public boolean isEmpty() {
		return graph.isEmpty();
	}
	
	public WeightedGraphEL(int size) {
		graph = new Graph(size);
		edgeList = new ArrayList<Edge>(size);
	}
	
	public WeightedGraphEL() {
		this(INITIAL_LENGTH);
	}
	
	public int find(int x) {
		return graph.find(x);
	}
	
	public void addVertex(int v) {
		graph.addVertex(v);
	}
	
	public void addEdge(int source, int destinaiton, double weight) {
		graph.init(source);
		graph.init(destinaiton);
		graph.union(source, destinaiton);
		edgeList.add(new Edge(source, destinaiton, weight));
	}
	
	public int nVertex() {
		return graph.len();
	}
	
	public int nEdges() {
		return edgeList.size();
	}
	 
	public WeightedGraphEL cloneVertex() {
		WeightedGraphEL wg = new WeightedGraphEL();
		wg.graph = this.graph.cloneVertex();
		return wg;
	}
	
	public boolean isTree() {
		if(graph.len() == 0)
			return true; //empty graph is a tree
		if(nEdges() != graph.len() - 1)
			return false;
		return graph.isConnex();
	}
	
	public void sort_edges() {
		edgeList = QuickSort.sort(edgeList, true);
	}
	
	public String toString() {
		return edgeList.toString();
	}
	
	public String toFullString() {
		return graph.toString() + "\n" + edgeList.toString();
	}
	
	/*
	 * Algorithms :
	 */
	
	public static WeightedGraphEL Kruskal(WeightedGraphEL wg) {
		WeightedGraphEL T = new WeightedGraphEL();
		T = wg.cloneVertex();
		wg.sort_edges();
		int n = T.nVertex();
		int c = 0;
		while (T.nEdges() < n-1) {
			Edge e = wg.edgeList.get(c++);
			int u = T.find(e.source);
			int v = T.find(e.destinaiton);
			if (u != v)
				T.addEdge(e.source, e.destinaiton, e.weight);
		}
		return T;
	}

}
