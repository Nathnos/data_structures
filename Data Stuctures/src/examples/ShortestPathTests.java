package examples;

import structures.WeightedGraph;
import algorithms.Graphs.*;

public class ShortestPathTests {
	public static void main(String[] args) {
		WeightedGraph wg = new WeightedGraph(6);
		wg.addEdge(0, 1, 8);
		wg.addEdge(0, 2, 2);
		wg.addEdge(0, 3, 4);
		wg.addEdge(1, 2, 7);
		wg.addEdge(1, 4, 2);
		wg.addEdge(2, 3, 1);
		wg.addEdge(2, 4, 3);
		wg.addEdge(2, 5, 9);
		wg.addEdge(3, 5, 5);
		System.out.println(wg); // The graph in WG.png
		System.out.println("Dijkstra : " + ShortestPath.Dijkstra(wg, 0));
	}
}
