package src;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFSLinked {
    public int vertices;
    public LinkedList<Integer> adjList[];

    public BFSLinked(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(Integer v, Integer w) {
        adjList[v].add(w);
    }

    public void BFS(Integer root) {
        boolean processed[] = new boolean[vertices];
        LinkedList<Integer> q = new LinkedList<Integer>();
        processed[root] = true;
        q.add(root);
        while (q.size() != 0) {
            root = q.poll();
            System.out.println(root + " ");
            Iterator<Integer> i = adjList[root].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!processed[n]) {
                    processed[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        InfoRead rr = new InfoRead();
        BFSLinked g = new BFSLinked(rr.firstGraphV(rr.getVertex(rr.findFile())).size() + 1);
        List<Integer> a = rr.firstGraphE(rr.getEdgesFirst(rr.findFile()));
        List<Integer> b = rr.firstGraphE(rr.getEdgesSecond(rr.findFile()));
        for (int i = 0; i < 11; i++) {
          g.addEdge(a.get(i), b.get(i));
        } 

        System.out.println("BFS Traversal: "); 
        g.BFS(rr.firstGraphV(rr.getVertex(rr.findFile())).get(0)); 

        System.out.println("\n=========================================================\n");

        InfoRead rr1 = new InfoRead();
        BFSLinked g1 = new BFSLinked(rr1.secondGraphV(rr1.getVertex(rr1.findFile())).size() + 1);
        List<Integer> a1 = rr1.secondGraphE(rr1.getEdgesFirst(rr1.findFile()));
        List<Integer> b1 = rr1.secondGraphE(rr1.getEdgesSecond(rr1.findFile()));
        for (int i = 0; i < 28; i++) {
          g1.addEdge(a1.get(i), b1.get(i));
        } 

        System.out.println("BFS Traversal: "); 
        g1.BFS(rr1.secondGraphV(rr1.getVertex(rr1.findFile())).get(7));

        System.out.println("\n=========================================================\n");

        BFSLinked g2 = new BFSLinked(rr.thirdGraphV(rr1.getVertex(rr1.findFile())).size() + 1);
        List<Integer> a2 = rr1.thirdGraphE(rr1.getEdgesFirst(rr1.findFile()));
        List<Integer> b2 = rr1.thirdGraphE(rr1.getEdgesSecond(rr1.findFile()));
        for (int i = 0; i < 62; i++) {
          g2.addEdge(a2.get(i), b2.get(i));
        } 

        System.out.println("BFS Traversal: "); 
        g2.BFS(rr1.thirdGraphV(rr1.getVertex(rr1.findFile())).get(20)); 

        System.out.println("\n=========================================================\n");

        BFSLinked g3 = new BFSLinked(rr.fourthGraphV(rr1.getVertex(rr1.findFile())).size() + 1);
        List<Integer> a3 = rr1.fourthGraphE(rr1.getEdgesFirst(rr1.findFile()));
        List<Integer> b3 = rr1.fourthGraphE(rr1.getEdgesSecond(rr1.findFile()));
        for (int i = 0; i < 72; i++) {
          g3.addEdge(a3.get(i), b3.get(i));
        } 

        System.out.println("BFS Traversal: "); 
        g3.BFS(rr1.fourthGraphV(rr1.getVertex(rr1.findFile())).get(0));

        System.out.println("\n=========================================================\n");

        BFSLinked g4 = new BFSLinked(rr.fifthGraphV(rr1.getVertex(rr1.findFile())).size() + 1);
        List<Integer> a4 = rr1.fifthGraphE(rr1.getEdgesFirst(rr1.findFile()));
        List<Integer> b4 = rr1.fifthGraphE(rr1.getEdgesSecond(rr1.findFile()));
        for (int i = 0; i < 25; i++) {
          g4.addEdge(a4.get(i), b4.get(i));
        } 

        System.out.println("BFS Traversal: "); 
        g4.BFS(rr1.fifthGraphV(rr1.getVertex(rr1.findFile())).get(0));
    }
}
