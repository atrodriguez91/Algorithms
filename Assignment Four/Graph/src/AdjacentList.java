package src;

import java.util.ArrayList;
// Similar to matrix, using a 2D arraylist to represent the graph.
public class AdjacentList {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, Integer i, Integer j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    // Printer of the list. 
    public static void printList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println(" => " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
    }
}
