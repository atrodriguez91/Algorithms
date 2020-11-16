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
            System.out.println("\nVertex: " + i);
            System.out.println("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
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
        // SECOND LIST START =======================================================
        System.out.println("\n===============================================\n");
        Integer V1 = r.secondGraphV(r.getVertex(r.findFile())).size() + 1;
        ArrayList<ArrayList<Integer> > adj1 = new ArrayList<ArrayList<Integer> >(V1);   
        for (int i = 0; i < V1; i++){ 
            adj1.add(new ArrayList<Integer>()); 
        }
        List<Integer> a1 = r.secondGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b1 = r.secondGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 28; i++) {
          addEdge(adj1, a1.get(i), b1.get(i));
        }
        printList(adj1);

        System.out.println("\n===============================================\n");
        Integer V2 = r.thirdGraphV(r.getVertex(r.findFile())).size() + 1;
        ArrayList<ArrayList<Integer> > adj2 = new ArrayList<ArrayList<Integer> >(V2);   
        for (int i = 0; i < V2; i++){ 
            adj2.add(new ArrayList<Integer>()); 
        }
        List<Integer> a2 = r.thirdGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b2 = r.thirdGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 62; i++) {
          addEdge(adj2, a2.get(i), b2.get(i));
        }
        printList(adj2);

        System.out.println("\n===============================================\n");
        Integer V3 = r.fourthGraphV(r.getVertex(r.findFile())).size() + 1;
        ArrayList<ArrayList<Integer> > adj3 = new ArrayList<ArrayList<Integer> >(V3);   
        for (int i = 0; i < V3; i++){ 
            adj3.add(new ArrayList<Integer>()); 
        }
        List<Integer> a3 = r.fourthGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b3 = r.fourthGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 72; i++) {
          addEdge(adj3, a3.get(i), b3.get(i));
        }
          
        printList(adj3);

        System.out.println("\n===============================================\n");
        Integer V4 = r.fifthGraphV(r.getVertex(r.findFile())).size() + 1;
        ArrayList<ArrayList<Integer> > adj4 = new ArrayList<ArrayList<Integer> >(V4);   
        for (int i = 0; i < V4; i++){ 
            adj4.add(new ArrayList<Integer>()); 
        }
        List<Integer> a4 = r.fifthGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b4 = r.fifthGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 25; i++) {
          addEdge(adj4, a4.get(i), b4.get(i));
        }
          
        printList(adj4);
    }
}
