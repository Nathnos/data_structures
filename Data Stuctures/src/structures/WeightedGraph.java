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

public class WeightedGraph {
	private static final int INITIAL_LENGTH = 8;
	private arrayList 
	
	private static class Vertex implements Comparable<Vertex> {
		public int cost = Integer.MAX_VALUE;
		public int predecessor = -1;
		public ArrayList<Vertex> neighbors;
		public Vertex() {
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
	
	private static class Edge implements Comparable<Edge> {
		int v1, v2;
		double weight;
		public Edge(int v1, int v2, double weight) {
			this.v2 = v1;
			this.v2 = v2;
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
			return "(" + v1 + ", " + v2 + ", " + weight + ")";
		}
	}
	
	public WeightedGraph(int size) {
		vertexList = new Vertex[size];
		edgeList = new ArrayList<Edge>(size);
		
	}
	
	public WeightedGraph() {
		this(INITIAL_LENGTH);
	}
	
	public boolean isEmpty() {
		return vertexList.isEmpty();
	}
	
	public void addVertex(int v) {
		vertexList[v] = new Vertex(v);
	}
	
	public void addEdge(int v1, int v2, double weight) {
		vertexList[v1].neighbors.add(vertexList[v2]);
		vertexList[v1].neighbors.add(vertexList[v1]);
		edgeList.add(new Edge(v1, v2, weight));
	}
	
	public int nVertex() {
		return vertexList.size();
	}
	
	public int nEdges() {
		return edgeList.size();
	}
	
	public void sort_edges() {
		edgeList = QuickSort.sort(edgeList, true);
	}
	
	public String toString() {
		return edgeList.toString();
	}
	
	/*
	 * Algorithms :
	 */
	
	public static WeightedGraph Kruskal(WeightedGraph wg) {
		WeightedGraph T = new WeightedGraph();
		UnionFind uf = new UnionFind();
		wg.sort_edges();
		int n = T.nVertex();
		int c = 0;
		while (T.nEdges() < n-1) {
			Edge e = wg.edgeList.get(c++);
			int u = uf.find(e.source);
			int v = uf.find(e.destinaiton);
			if (u != v) {
				T.addEdge(e.source, e.destinaiton, e.weight);
				uf.init(u);
				uf.init(v);
				uf.union(u, v);
			}
		}
		return T;
	}
	
//	public static WeightedGraph Prim(WeightedGraph wg) {
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
//		return null;
//	}
//
//	public static WeightedGraph Dijkstra(WeightedGraph wg) {
//		return null;
//	}

}
