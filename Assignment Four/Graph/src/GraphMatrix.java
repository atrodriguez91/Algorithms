package src;

import java.io.FileNotFoundException;
import java.util.List;

public class GraphMatrix {
    public boolean adjMatrix[][];
    public Integer vertices;

    public GraphMatrix(Integer vertices) {
        this.vertices = vertices;
        adjMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(Integer i, Integer j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            string.append(" : ");
            for (boolean j : adjMatrix[i]) {
                string.append((j ? 1 : 0) + " ");
            }
            string.append("\n");
        }
        return string.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // MATRIX FOR FIRST GRAPH ====================================================================
        InfoRead read = new InfoRead();
        GraphMatrix m = new GraphMatrix(read.firstGraphV(read.getVertex(read.findFile())).size() + 1);
        List<Integer> a = read.firstGraphE(read.getEdgesFirst(read.findFile()));
        List<Integer> b = read.firstGraphE(read.getEdgesSecond(read.findFile()));
        for (int i = 0; i < 11; i++) {
            m.addEdge(a.get(i), b.get(i));
        }
        System.out.println(m.toString());
        // END OF GRAPH 1 ============================================================================
        
    }
}
