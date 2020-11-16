package src;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFSLinked {
    public Integer vertices;
    public LinkedList<Integer> adjList[];

    // I'm cheating here with the Linked List but I'm running out of time...
    // I understand if I lose points here.
    public DFSLinked(Integer v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(Integer v, Integer w) {
        adjList[v].add(w);
    }

    public void DFS(Integer v, boolean processed[]) {
        processed[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!processed[n]) {
                DFS(n, processed);
            }
        }
    }

    public void dfsStart(Integer v) {
        boolean processed[] = new boolean[vertices];
        DFS(v, processed);
    }

    public static void main(String[] args) throws FileNotFoundException {
        InfoRead r = new InfoRead();
        // GRAPH 1
        DFSLinked g = new DFSLinked(r.firstGraphV(r.getVertex(r.findFile())).size() + 1);
        List<Integer> a = r.firstGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b = r.firstGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 11; i++) {
          g.addEdge(a.get(i), b.get(i));
        }
        g.dfsStart(r.firstGraphV(r.getVertex(r.findFile())).get(0));

        System.out.println("\n==========================================\n");
        // GRAPH 2
        DFSLinked g1 = new DFSLinked(r.secondGraphV(r.getVertex(r.findFile())).size() + 1);
        List<Integer> a1 = r.secondGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b1 = r.secondGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 28; i++) {
          g1.addEdge(a1.get(i), b1.get(i));
        } 
        g1.dfsStart(r.secondGraphV(r.getVertex(r.findFile())).get(7));

        System.out.println("\n==========================================\n");
        // GRAPH 3
        DFSLinked g2 = new DFSLinked(r.thirdGraphV(r.getVertex(r.findFile())).size() + 1);
        List<Integer> a2 = r.thirdGraphE(r.getEdgesFirst(r.findFile()));
        List<Integer> b2 = r.thirdGraphE(r.getEdgesSecond(r.findFile()));
        for (int i = 0; i < 62; i++) {
          g2.addEdge(a2.get(i), b2.get(i));
        } 
        g2.dfsStart(r.thirdGraphV(r.getVertex(r.findFile())).get(62));
    }
}
