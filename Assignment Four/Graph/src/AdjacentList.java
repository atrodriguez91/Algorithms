package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws FileNotFoundException {
        InfoRead r = new InfoRead(); 
        // FIRST LIST START ========================================================
        Integer V = r.firstGraphV(r.getVertex(r.findFile())).size() + 1;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);   
        for (int i = 0; i < V; i++){ 
            adj.add(new ArrayList<Integer>()); 
        }
        List<Integer> a = r.firstGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b = r.firstGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 11; i++) {
          addEdge(adj, a.get(i), b.get(i));
        } 
        printList(adj);
        // END OF FIRST LIST =======================================================
    }
}
