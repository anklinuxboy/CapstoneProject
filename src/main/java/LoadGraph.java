package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ankit on 3/13/17.
 */
public class LoadGraph {

    private static String FILENAME = "src/data/test_graph3.txt";

    public static NetworkGraph loadGraph() {
        NetworkGraph graph = new NetworkGraph();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(FILENAME);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // The dataset is in the form of "key neighbor" so this approach works.
                String[] numbers = line.split(" ");
                int follower = Integer.parseInt(numbers[0]);
                int followed = Integer.parseInt(numbers[1]);
                graph.addEdge(follower, followed);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (fileReader != null) fileReader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        }

        return graph;
    }
}
