package algorithms.Graphs;

import structures.WeightedGraph;
import structures.WeightedGraphEL;

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
	
	
	public static WeightedGraphEL Kruskal(WeightedGraphEL wg) {
		return WeightedGraphEL.Kruskal(wg);
	}
	
	public static WeightedGraphEL find(WeightedGraphEL wg) {
		return Kruskal(wg);
	}
	
}
