package main.java;

import java.util.HashSet;

/**
 * Created by ankit on 3/13/17.
 */
public interface Graph {
    public void addVertex(int vertex);

    public void addEdge(int v, int w);

    public int getNumberOfVertices();

    public int getNumberOfEdges();

    public void printGraph();

    // Returns null if vertex not present
    public HashSet<Integer> getNeighbors(int v);
}
