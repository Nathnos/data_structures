package structures.graphs;

import structures.UnionFind;

/*
 * Undirected graph. Tells you if two edges are connected (Union Find)
 * 
 * Vertex are integers
 *
 * Application of UnionFind. Elements are vertex, and edges are connections.
 * Vertex and edges cannot be removed.
 *
 * You don't need to initialize vertex before adding edges.
 */

public class Graph extends UnionFind {
  public Graph(int length) {
    super(length);
  }

  public Graph() {
    super();
  }

  public void addVertex(int v) {
	  init(v);
  }

  public void addEdge(int source, int destination) {
    addVertex(source);
    addVertex(destination);
	  union(source, destination);
  }

  public boolean isConnex() {
    if(len() == 0)
      return true; //empty graph is connex
    int i = 0;
    while(parent[i] == -1)
      i++;
    int group = find(i);
    for (int k = i+1; i<parent.length; i++) {
      if(find(k) != group)
        return false;
    }
    return true;
  }

  //Create a new graph with same vertex, but without edges
  public Graph cloneVertex() {
    Graph graph = new Graph();
    for(int i = 0; i<parent.length; i++) {
      if(parent[i] != -1)
        graph.init(i);
    }
    return graph;
  }

}
