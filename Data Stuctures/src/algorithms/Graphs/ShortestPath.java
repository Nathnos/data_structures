package algorithms.Graphs;

import structures.WeightedGraph;

/*
 * Algorithms to find the minimal spanning tree, from a WeightedGraph.
 */

public class ShortestPath {
	public static WeightedGraph Dijkstra(WeightedGraph wg, int vertex) {
		return WeightedGraph.Dijkstra(wg, vertex);
	}
	public static WeightedGraph find(WeightedGraph wg, int vertex) {
		return Dijkstra(wg, vertex);
	}
	
}
