package main.java;

/**
 * Created by ankit on 3/14/17.
 */
public class Main {
    public static void main(String[] args) {
        NetworkGraph graph = LoadGraph.loadGraph();
        graph.printGraph();
    }
}
