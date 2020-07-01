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
		
		DirGraph web = new DirGraph();
		web.addEdge(1, 2);
		web.addEdge(1, 3);
		web.addEdge(1, 4);
		web.addEdge(2, 1);
		web.addEdge(4, 3);
		web.addEdge(4, 5);
		web.addEdge(5, 2);
		web.addEdge(5, 3);
		web.addEdge(5, 4);
		web.breadth_first_search(1);
	}
}
