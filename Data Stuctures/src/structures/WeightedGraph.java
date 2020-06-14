package structures;

import java.util.ArrayList;
import algorithms.ListSorting.*;

/*
 * Weighted, undirected graphs.
 * 
 * Uses Adjacency list.
 * 
 * Implicit edges are no longer sufficient, since they have a weight.
 * Do not add two times the same edge. addEdge won't check if it already exists.
 */

uses Adjacency list

public class WeightedGraph {
	private static final int INITIAL_LENGTH = 8;
	private ArrayList<Edge> edgeList;
	private Graph graph;
	
	private static class Vertex implements Comparable<Vertex> {
		public int cost = Integer.MAX_VALUE;
		public int from = -1;
		public final int id;
		public ArrayList<Vertex> neighbors;
		public Vertex(int id) {
			this.id = id;
			neighbors = new ArrayList<Vertex>();
		}
		public void reset() {
			cost = Integer.MAX_VALUE;
			from = -1;
		}
		@Override
		public int compareTo(Vertex v) {
			if(cost > v.cost)
				return 1;
			else if (cost == v.cost)
				return 0;
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return graph.isEmpty();
	}
	
	public WeightedGraph(int size) {
		graph = new Graph(size);
		edgeList = new ArrayList<Edge>(size);
	}
	
	public WeightedGraph() {
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
	 
	public WeightedGraph cloneVertex() {
		WeightedGraph wg = new WeightedGraph();
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
	
	public static WeightedGraph Prim(WeightedGraph wg) {
		int n = wg.nVertex();
		Vertex[] vertexList = new Vertex[n];
		int[] cost = new int[n];
		int c = 0;
		for(int i = 0; i < n; i++) {
			if(wg.graph.exists(i))
				vertexList[c++] = new Vertex(i);
		}
		for(Edge e : edgeList) { // add neighbors
			…;//FAUT LE FAIRE EN AVANCE (garder trace…)
		}
		vertexList[0].cost = 0;
		PQ<Vertex> f = new PQ<Vertex>(false, 4, n); //Min, 4-heap, size n
		for(int i = 0; i < n; i++)
			f.insert(vertexList[i]);
		while(!f.isEmpty()) {
			Vertex v = f.delete();
		}
		return null;
	}

	public static WeightedGraph Dijkstra(WeightedGraph wg) {
		return null;
	}

}
