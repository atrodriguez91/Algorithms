import java.io.FileNotFoundException;
import java.util.List;

class SSSPBellmanFord {

    class Edge {
        int s;
        int d; 
        int w;

        Edge() {
            s = 0; 
            d = 0;
            w = 0;
        }
    };

    int V, E;
    Edge edge[];

    SSSPBellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public static void BellmanFordProc(SSSPBellmanFord graph, int s) {
        int V = graph.V;
        int E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[s] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].s;
                int v = graph.edge[j].d;
                int w = graph.edge[j].w;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].s;
            int v = graph.edge[j].d;
            int w = graph.edge[j].w;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("SSSPBellmanFord contains negative w cycle");
                return;
            }
        }
        printSolution(dist, V);
    }

    static void printSolution(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + " " + "cost is" + " " + dist[i] + "; " + "path: " );
    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SSSP n = new SSSP();
    int V = 6;
    int E = 10; 

    SSSPBellmanFord graph = new SSSPBellmanFord(V, E);

    int[] a = convertIntegers(n.firstGraphE(n.getEdgesFirst(n.findFile())));
    int[] b = convertIntegers(n.firstGraphE(n.getEdgesSecond(n.findFile())));
    int[] c = convertIntegers(n.firstGraphE(n.getEdgesWeight(n.findFile())));

    for (int i = 0; i < E; i++) {
        graph.edge[i].s = a[i];
        graph.edge[i].d = b[i];
        graph.edge[i].w = c[i];
    }
    SSSPBellmanFord.BellmanFordProc(graph, 2);

    int V1 = 8; 
    int E1 = 12; 

    SSSPBellmanFord graph1 = new SSSPBellmanFord(V1, E1);

    int[] a1 = convertIntegers(n.secondGraphE(n.getEdgesFirst(n.findFile())));
    int[] b1 = convertIntegers(n.secondGraphE(n.getEdgesSecond(n.findFile())));
    int[] c1 = convertIntegers(n.secondGraphE(n.getEdgesWeight(n.findFile())));

    for (int i = 0; i < E1; i++) {
        graph1.edge[i].s = a1[i];
        graph1.edge[i].d = b1[i];
        graph1.edge[i].w = c1[i];
    }
    SSSPBellmanFord.BellmanFordProc(graph1, 1);

    int V2 = 8; 
    int E2 = 12; 

    SSSPBellmanFord graph2 = new SSSPBellmanFord(V2, E2);

    int[] a2 = convertIntegers(n.thirdGraphE(n.getEdgesFirst(n.findFile())));
    int[] b2 = convertIntegers(n.thirdGraphE(n.getEdgesSecond(n.findFile())));
    int[] c2 = convertIntegers(n.thirdGraphE(n.getEdgesWeight(n.findFile())));

    for (int i = 0; i < E2; i++) {
        graph2.edge[i].s = a2[i];
        graph2.edge[i].d = b2[i];
        graph2.edge[i].w = c2[i];
    }
    SSSPBellmanFord.BellmanFordProc(graph2, 1);

    int V3 = 8; // Total vertices
    int E3 = 12; // Total Edges

    SSSPBellmanFord graph3 = new SSSPBellmanFord(V3, E3);

    int[] a3 = convertIntegers(n.fourthGraphE(n.getEdgesFirst(n.findFile())));
    int[] b3 = convertIntegers(n.fourthGraphE(n.getEdgesSecond(n.findFile())));
    int[] c3 = convertIntegers(n.fourthGraphE(n.getEdgesWeight(n.findFile())));

    for (int i = 0; i < E3; i++) {
        graph3.edge[i].s = a3[i];
        graph3.edge[i].d = b3[i];
        graph3.edge[i].w = c3[i];
    }
    SSSPBellmanFord.BellmanFordProc(graph3, 1);
    }
  }