package src;

import java.io.FileNotFoundException;
import java.util.List;
// Graphical matrix for file input.
// Credit: GeeksforGeeks for basic matrix structure. 
// Pretty straight forward in terms of implementing.
// Much more difficult to format it to fit with 
// the file input. 
public class GraphMatrix {
    public boolean adjMatrix[][];
    public Integer vertices;

    public GraphMatrix(Integer vertices) {
        this.vertices = vertices;
        adjMatrix = new boolean[vertices][vertices];
    }
    // Method to introduce both edges into 2D array. 
    public void addEdge(Integer i, Integer j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }
    // Print of the array. 
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            string.append(i + " : ");
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
        // MATRIX FOR SECOND GRAPH ===================================================================
        System.out.println("\n======================================\n");
        GraphMatrix m1 = new GraphMatrix(read.secondGraphV(read.getVertex(read.findFile())).size() + 1);
        List<Integer> a1 = read.secondGraphE(read.getEdgesFirst(read.findFile()));
        List<Integer> b1 = read.secondGraphE(read.getEdgesSecond(read.findFile()));
        for (int i = 0; i < 28; i++) {
          m1.addEdge(a1.get(i), b1.get(i));
        }
        System.out.println(m1.toString());
        // END OF GRAPH 2 ============================================================================
        // MATRIX FOR THIRD GRAPH ====================================================================
        System.out.println("\n======================================\n");
        GraphMatrix m2 = new GraphMatrix(read.thirdGraphV(read.getVertex(read.findFile())).size() + 1);
        List<Integer> a2 = read.thirdGraphE(read.getEdgesFirst(read.findFile()));
        List<Integer> b2 = read.thirdGraphE(read.getEdgesSecond(read.findFile()));
        for (int i = 0; i < 62; i++) {
          m2.addEdge(a2.get(i), b2.get(i));
        }
        System.out.println(m2.toString());
        // END OF GRAPH 3 ============================================================================
        // MATRIX FOR FOURTH GRAPH ===================================================================
        System.out.println("\n======================================\n");
        GraphMatrix m3 = new GraphMatrix(read.fourthGraphV(read.getVertex(read.findFile())).size() + 1);
        List<Integer> a3 = read.fourthGraphE(read.getEdgesFirst(read.findFile()));
        List<Integer> b3 = read.fourthGraphE(read.getEdgesSecond(read.findFile()));
        for (int i = 0; i < 72; i++) {
            m3.addEdge(a3.get(i), b3.get(i));
        }
        System.out.println(m3.toString());
        // END OF GRAPH 4 ============================================================================
        // MATRIX FOR FIFTH GRAPH ====================================================================
        System.out.println("\n======================================\n");
        GraphMatrix m4 = new GraphMatrix(read.fifthGraphV(read.getVertex(read.findFile())).size() + 1);
        List<Integer> a4 = read.fifthGraphE(read.getEdgesFirst(read.findFile()));
        List<Integer> b4 = read.fifthGraphE(read.getEdgesSecond(read.findFile()));
        for (int i = 0; i < 25; i++) {
            m4.addEdge(a4.get(i), b4.get(i));
        }
        System.out.println(m4.toString());
        // END OF GRAPH 5=============================================================================
    }
}
