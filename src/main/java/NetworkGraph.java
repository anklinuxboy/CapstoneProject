package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by ankit on 3/13/17.
 */
public class NetworkGraph implements Graph {

    private Map<Integer, HashSet<Integer>> graph;
    int vertices;
    int edges;

    public NetworkGraph() {
        graph = new HashMap<>();
        vertices = 0;
        edges = 0;
    }

    @Override
    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new HashSet<>());
            vertices++;
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (!graph.containsKey(v)) {
            addVertex(v);
        }
        graph.get(v).add(w);
        edges++;
    }

    @Override
    public int getNumberOfVertices() {
        return vertices;
    }

    @Override
    public int getNumberOfEdges() {
        return edges;
    }

    @Override
    public void printGraph() {
        for (int key : graph.keySet()) {
            System.out.println("Key: " + key + ", Neighbors: " + graph.get(key));
        }
    }

    @Override
    public HashSet<Integer> getNeighbors(int v) {
        if (graph.containsKey(v))
            return graph.get(v);
        else
            return null;
    }
}
