package structures;

import java.util.ArrayList;
import algorithms.ListSorting.*;

/*
 * Weighted, Directed graph. Uses edge list representation.
 * Vertex are represented as integers.
 * 
 * Do not add two times the same edge. addEdge() function won't check if it already exists.
 * To change a weight, use the updateEdge() function.
 */


public class WeightedGraphL extends WeightedGraph {
	private static final int INITIAL_LENGTH = 8;
	private ArrayList<Edge> edgeList;
	
	private class Edge() {
		
	}
	
	public WeightedGraphL(int size) {
		graph = new Graph(size);
		edgeList = new ArrayList<Edge>(size);
	}
	
	public WeightedGraphL() {
		this(INITIAL_LENGTH);
	}
	
	public boolean isEmpty() {
		return edgeList.isEmpty();
	}
	
	public int find(int x) {
		return graph.find(x);
	}
	
	public void addVertex(int v) {
		graph.addVertex(v);
	}
	
	public void addEdge(int source, int destination, double weight) {
		graph.init(source);
		graph.init(destination);
		graph.union(source, destination);
		edgeList.add(new Edge(source, destination, weight));
	}
	
	public void updateEdge(int source, int destination, double weight) {
		for(Edge e : edgeList)
			if(e.source == source && e.destination == destination) {
				e.weight = weight;
				break;
			}
	}
	
	public int nVertex() {
		return graph.len();
	}
	
	public int nEdges() {
		return edgeList.size();
	}
	 
	public WeightedGraphL cloneVertex() {
		WeightedGraphL wg = new WeightedGraphL();
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
	
	public static WeightedGraphL Kruskal(WeightedGraphL wg) {
		WeightedGraphL T = new WeightedGraphL();
		T = wg.cloneVertex();
		wg.sort_edges();
		int n = T.nVertex();
		int c = 0;
		while (T.nEdges() < n-1) {
			Edge e = wg.edgeList.get(c++);
			int u = T.find(e.source);
			int v = T.find(e.destination);
			if (u != v)
				T.addEdge(e.source, e.destination, e.weight);
		}
		return T;
	}

	
	/*
	 * Work in progress
	 */

//	public WeightedGraphs Prim(Graph graph) {
//		WeightedGraphs T = new WeightedGraphs();
//		int c = 0;
//		int n = graph.len();
//		int[] cout_min = new int[n-1];
//		int[] voisin = new int[n-1];
//		cout_min[c++] = -1;
//		for (int i = 2; i<n; i++) {
//		//voisin[i] =;
//		}
//		while(T.len() < n-1) {
//		break;
//		}
//		return T;
//	}
	
//	public Dijkstra(matrice L, Graph graph) { //Donne pas tjrs un ACM
//		//Matrice L représente les poids :L[i, j] le poids
//		//de l'arrête entre i et j (infini si pas d'arrête)
//		int[] D = int[n];
//		int[] P = int[n];
//		C = {} //Candidats possibles
//		//on veut que enlever min; voir struct de donnée appropriée
//		//Tas binaire min ?
//		//Aussi pouvoir parcourir cette structure :
//		//ok avec tas binaire, mais ordre arbitraire
//		for(int i = 0; i<n; i++) {
//		P[i] = 0
//		D[i] = ; //Poids de l'arrête, ou infini
//		}
//		P[0] = -1; //Aucun voisins
//		while(C != null) {
//		int v = C.removeMni();
//		for w in C
//		}
//	}

}
