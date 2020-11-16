package src;

import java.util.ArrayList;

public class AdjacentList {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, Integer i, Integer j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public static void printList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            
        }
    }

    public static void main(String[] args) {
        
    }
}
