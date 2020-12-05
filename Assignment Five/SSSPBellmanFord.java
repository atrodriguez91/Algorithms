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
    }
  }