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
    }
}
