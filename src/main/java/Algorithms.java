package main.java;

import java.util.HashSet;

/**
 * Created by ankit on 3/26/17.
 */
public interface Algorithms {
    // Return an unoptimized Dominating Set from the graph
    public HashSet<Integer> naiveDominatingSet(Graph graph);

    // Check if two nodes are reachable
    public boolean BFS(Graph graph, int source, int destination);
}
