package main.java;

import java.util.*;

/**
 * Created by ankit on 3/13/17.
 */
public class NetworkGraph implements Graph {

    private Map<Integer, HashSet<Integer>> graph;
    private GraphAlgorithms algorithms;
    int vertices;
    int edges;

    public NetworkGraph() {
        graph = new HashMap<>();
        vertices = 0;
        edges = 0;
        algorithms = new GraphAlgorithms();
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
    public Set<Integer> getKeys() {
        return graph.keySet();
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

    public boolean isNodeReachable(int v, int w) {
        if (v < 0 || w < 0) {
            throw new IllegalArgumentException();
        }

        int source = -1, destination = -1;
        if (graph.containsKey(v)) {
            source = v;
            destination = w;
        } else if (graph.containsKey(w)) {
            source = w;
            destination = v;
        }

        return algorithms.BFS(this, source, destination);
    }

    public HashSet<Integer> getDominatingSet() {
        return algorithms.naiveDominatingSet(this);
    }
}
