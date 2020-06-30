package algorithms.Graphs;

import structures.graphs.WeightedGraph;

public class MST {
	public static WeightedGraph Prim(WeightedGraph wg) {
		return WeightedGraph.Prim(wg);
	}
	
	public static WeightedGraph Kruskal(WeightedGraph wg) {
		return WeightedGraph.Kruskal(wg);
	}
	
	public static WeightedGraph find(WeightedGraph wg) {
		return Kruskal(wg);
	}
	
}
