package examples;

import algorithms.Graphs.*;
import structures.graphs.WeightedGraph;

public class MinimalSpanningTree {
	public static void main(String[] args) {
		WeightedGraph wg = new WeightedGraph(6);
		wg.addEdge(0, 1, 2);
		wg.addEdge(0, 2, 8);
		wg.addEdge(0, 4, 7);
		wg.addEdge(1, 2, 5);
		wg.addEdge(1, 3, 7);
		wg.addEdge(2, 3, 9);
		wg.addEdge(2, 4, 8);
		wg.addEdge(3, 5, 4);
		wg.addEdge(4, 5, 3);
		System.out.println(wg); // The graph in WG.png
		System.out.println("Kruskal : " + MST.Kruskal(wg)); // Should give the tree in MST.png
		System.out.println("Prim : " + MST.Prim(wg)); // Should give the tree in MST.png
	}
}
