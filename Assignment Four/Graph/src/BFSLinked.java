package src;

import java.util.Iterator;
import java.util.LinkedList;

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
        while(q.size() != 0) {
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
    public static void main(String[] args) {
        
    }
}
