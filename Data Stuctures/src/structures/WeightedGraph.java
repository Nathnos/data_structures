package structures;

import java.util.ArrayList;
import java.util.LinkedList;

import algorithms.ListSorting.*;

/*
 * Weighted, undirected graph.
 * 
 * Uses Adjacency list.
 * 
 * Implicit edges are no longer sufficient, since they have a weight.
 * Do not add two times the same edge. addEdge won't check if it already exists.
 */

public class WeightedGraph {
	private LinkedList<Edge>[] adjacencyList; //Store edges for each vertex
	private ArrayList<Edge> edgeList;
	private int vertices;
	
	private static class Edge implements Comparable<Edge> {
		int source, destination;
		double weight;
		public Edge(int source, int destination, double weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "(" + source + ", " + destination + ", " + weight + ")";
		}
		@Override
		public int compareTo(Edge e) {
			if(this.weight > e.weight)
				return 1;
			else if(this.weight == e.weight)
				return 0;
			return -1;
		}
	}
	
	@SuppressWarnings("unchecked")
	public WeightedGraph(int vertices) {
		this.vertices = vertices;
		edgeList = new ArrayList<Edge>(vertices);
		adjacencyList = new LinkedList[vertices];
		for(int i = 0; i<vertices; i++)
			adjacencyList[i] = new LinkedList<Edge>();
	}

	public boolean isEmpty() {
		return edgeList.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public void setVerticesNumber(int verticesNumber) {
		int diff = verticesNumber - vertices;
		if(diff < 0)
			return;
		LinkedList<Edge>[] newAdjacencyList = new LinkedList[vertices];
		for(int i = 0; i<vertices; i++) //Copy
			newAdjacencyList[i] = adjacencyList[i];
		for(int i = 0; i<diff; i++) //Get extra space
			newAdjacencyList[i+vertices] = new LinkedList<Edge>();
		adjacencyList = newAdjacencyList;
		vertices = verticesNumber;
	}
	
	public void addEdge(int source, int destination, double weight) {
		Edge e1 = new Edge(source, destination, weight);
		Edge e2 = new Edge(destination, source, weight);
		adjacencyList[source].addFirst(e1);
		adjacencyList[destination].addFirst(e2);
		edgeList.add(e1);
	}
	
	public int nVertex() {
		return vertices;
	}
	
	public int nEdges() {
		return edgeList.size();
	}
	
	public String toString() {
		return edgeList.toString();
	}
	
	private void sortEdges() {
		QuickSort.sort(edgeList, true);
	}
	
	/*
	 * Algorithms :
	 */
	
	public static WeightedGraph Kruskal(WeightedGraph wg) {
		int n = wg.nVertex();
		WeightedGraph T = new WeightedGraph(n);
		UnionFind uf = new UnionFind();
		wg.sortEdges();
		int c = 0;
		for(int i = 0; i<wg.nVertex(); i++)
			uf.init(i);
		while (T.nEdges() < n-1) {
			Edge e = wg.edgeList.get(c++);
			System.out.println(e);
			int u = uf.find(e.source);
			int v = uf.find(e.destination);
			if (u != v) {
				T.addEdge(e.source, e.destination, e.weight);
				uf.union(u, v);
			}
		}
		return T;
	}
	
	public static WeightedGraph Prim(WeightedGraph wg) {
//		PQ<Vertex> f = new PQ<Vertex>(false, 2, n); //Min, binary heap, size n
//		for(Vertex v : wg.vertexList) {
//			v.reset();
//			f.insert(v);
//		}
//		Vertex v0 = wg.vertexList.get(0);
//		v0.cost = 0;
//		f.update(v0);
//		while(!f.isEmpty()) {
//			Vertex v = f.delete();
//		}
		return null;
	}

	public static WeightedGraph Dijkstra(WeightedGraph wg) {
		return null;
	}

}
