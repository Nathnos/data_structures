package structures.graphs;

import java.util.ArrayList;

import algorithms.ListSorting.QuickSort;

/*
 * 	Directed graph.
 * 
 *  You should not add twice the same edge or vertex. If so, you can use auto_clean() method.
 */

public class DirGraph {
	private ArrayList<Vertex> vertexList;
	private ArrayList<Edge> edgeList;
	
	/*
	 * Vertex and Edge class
	 */
	
	private static class Vertex implements Comparable<Vertex> {
		int id;
		ArrayList<Vertex> neighbors;
		public Vertex(int id) {
			neighbors = new ArrayList<Vertex>();
			this.id = id;
		}
		@Override
		public String toString() {
			return "" + id;
		}
		@Override
		public int compareTo(Vertex v) {
			if(id > v.id)
				return 1;
			else if(id < v.id)
				return -1;
			return 0;
		}
	}
	
	private static class Edge implements Comparable<Edge>  {
		int source;
		int destination;
		public Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
		@Override
		public String toString() {
			return "(" + source + ";" + destination + ")";
		}
		@Override
		public int compareTo(Edge e) {
			if(source > e.source)
				return 1;
			else if(source < e.source)
				return -1;
			//If source == e.source :
			if(destination > e.destination)
				return 1;
			else if(destination < e.destination)
				return -1;
			return 0;
		}
	}
	
	/*
	 * Constructor :
	 */
	
	public DirGraph() {
		edgeList = new ArrayList<Edge>();
		vertexList = new ArrayList<Vertex>();
	}
	
	/*
	 * Methods :
	 */
	
	
	public ArrayList<Vertex> getNeighbors(Vertex vertex) {
		// Careful ; this should be used read-only !
		return vertex.neighbors;
	}
	
	public Vertex addVertex(int id) {
		Vertex v = new Vertex(id);
		vertexList.add(v);
		return v;
	}
	
	public Vertex removeVertex(int id) {
		Vertex vertex = null;
		for(int i = 0; i<vertexList.size(); i++) {
			Vertex v = vertexList.get(i);
			if(v.id == id) {
				vertex = v;
				vertexList.remove(i);
				break;
			}
		}
		return vertex;
	}
	
	private Vertex findVertex(int id) {
		for(Vertex v : vertexList){
			if(v.id == id)
				return v;
		}
		return null;
	}

	public Edge addEdge(int source, int dest) {
		Edge e = new Edge(source, dest);
		edgeList.add(e);
		Vertex v = findVertex(source);
		Vertex neighbor = findVertex(dest);
		if(v == null)
			v = addVertex(source);
		if(neighbor == null)
			neighbor = addVertex(dest);
		v.neighbors.add(neighbor);
		return e;
	}
	
	public Edge removeEdge(int source, int dest) {
		Edge edge = null;
		for(int i = 0; i<edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			if(e.source == source && e.destination == dest) {
				edge = e;
				edgeList.remove(i);
				break;
			}
		}
		return edge;
	}
	
	public void auto_clean() {
		//If you messed up and added multiple times vertices or edges.
		QuickSort.sort(vertexList, true);
		QuickSort.sort(edgeList, true);
		Vertex vertex = vertexList.get(0);
		for(int i = 1; i<vertexList.size(); i++) {
			Vertex v = vertexList.get(i);
			if(v.compareTo(vertex) == 0)
				vertexList.remove(i);
			else
				vertex = v;
		}
		Edge edge = edgeList.get(0);
		for(int i = 1; i<edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			if(e.compareTo(edge) == 0)
				edgeList.remove(i);
			else
				edge = e;
		}
	}
	
	@Override
	public String toString() {
		return "Vertices : " + vertexList.toString() + "\n Edges : " + edgeList.toString();
	}
	
	/*
	 * Algorithms :
	 */
	
	public void webCrawler() {
		return;
	}
}
