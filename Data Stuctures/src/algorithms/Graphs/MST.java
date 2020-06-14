package algorithms.Graphs;

import structures.WeightedGraph;
/*
 * Algorithms to find the minimal spanning tree, from a WeightedGraph.
 */

public class MST {
	public static WeightedGraph Prim(WeightedGraph wg) {
		return WeightedGraph.Prim(wg);
	}
	
	public static WeightedGraph find(WeightedGraph wg) {
		return Prim(wg);
	}
	
	
	public static WeightedGraph Kruskal(WeightedGraph wg) {
		return WeightedGraph.Kruskal(wg);
	}
	
}
