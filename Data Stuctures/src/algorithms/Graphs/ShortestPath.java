package algorithms.Graphs;

import structures.WeightedGraph;

/*
 * Algorithms to find the minimal spanning tree, from a WeightedGraph.
 */

public class ShortestPath {
	public static WeightedGraph Dijkstra(WeightedGraph wg) {
		return WeightedGraph.Dijkstra(wg);
	}
	public static WeightedGraph find(WeightedGraph wg) {
		return Dijkstra(wg);
	}
	
}
