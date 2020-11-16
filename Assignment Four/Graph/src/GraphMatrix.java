package src;

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
}
