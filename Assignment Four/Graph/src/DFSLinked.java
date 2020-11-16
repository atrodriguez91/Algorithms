package src;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSLinked {
    public Integer vertices;
    public LinkedList<Integer> adjList[];

    public void DFSLinked(Integer v) {
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
}
