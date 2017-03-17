package main.java;

import java.util.Scanner;

/**
 * Created by ankit on 3/14/17.
 */
public class Main {
    public static void main(String[] args) {
        NetworkGraph graph = LoadGraph.loadGraph();
        //graph.printGraph();
        System.out.println("Enter two nodes to search");

        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        boolean pathExists = graph.isNodeReachable(source, destination);

        if (pathExists)
            System.out.println("Path exists");
        else {
            System.out.println("No Path exists");
        }
    }
}
