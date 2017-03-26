package main.java;

import java.util.*;

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

    public boolean isNodeReachable(int v, int w) {
        if (v < 0 || w < 0) {
            throw new IllegalArgumentException();
        }

        //
        int source = -1, destination = -1;
        if (graph.containsKey(v)) {
            source = v;
            destination = w;
        } else if (graph.containsKey(w)) {
            source = w;
            destination = v;
        }

        return BFS(source, destination);
    }

    private boolean BFS(int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> nodes = new LinkedList<>();

        visited.add(source);
        nodes.add(source);

        // there will only be a path if atleast one of the vertex follows someone in the graph
        while (!nodes.isEmpty()) {
            int node = nodes.remove();
            if (node == destination)
                return true;

            HashSet<Integer> neighbors = getNeighbors(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        nodes.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    public HashSet<Integer> naiveDominatingSet() {
        return null;
    }
}
