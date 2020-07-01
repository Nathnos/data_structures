package examples;

import structures.graphs.DirGraph;

public class DirectedGraphs {

	public static void main(String[] args) {
		DirGraph graph = new DirGraph();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addEdge(0, 1);
		graph.addEdge(3, 1);
		graph.addEdge(3, 1);
		graph.addVertex(3);
		graph.addVertex(3);
		graph.addVertex(2);
		graph.auto_clean();
		System.out.println(graph);
	}

}
