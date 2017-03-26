package main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ankit on 3/26/17.
 */
public class GraphAlgorithms implements Algorithms {

    public HashSet<Integer> naiveDominatingSet(Graph graph) {
        HashSet<Integer> covered = new HashSet<>();
        Set<Integer> keys = graph.getKeys();
        int maxNeighbors = 0;
        while (covered.size() != keys.size()) {
            for (int key : keys) {
                if (!covered.contains(key)) {
                    if (graph.getNeighbors(key).size() > maxNeighbors) {
                        maxNeighbors = key;
                    }
                }
            }
            covered.add(maxNeighbors);
            maxNeighbors = 0;
        }

        return covered;
    }

    public boolean BFS(Graph graph, int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> nodes = new LinkedList<>();

        visited.add(source);
        nodes.add(source);

        // there will only be a path if atleast one of the vertex has a path towards another vertex in the graph
        while (!nodes.isEmpty()) {
            int node = nodes.remove();
            if (node == destination)
                return true;

            HashSet<Integer> neighbors = graph.getNeighbors(node);
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
}
