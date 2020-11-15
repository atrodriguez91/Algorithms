import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;






public class Graphs {
    public static String[] graphFile;
    public static String[] vertexArray;
    public static String[] newArray;
    public static int [] intArray;
    public static ArrayList<Integer> numList = new ArrayList<Integer>();
    public static int[][] matrix;
    public static boolean[][] isMatrix;

    public void Graph(int nodes, boolean directed, boolean weighted) {
        matrix = new int[nodes][nodes];
        isMatrix = new boolean[nodes][nodes];
    }

    public static String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph1.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while (graphScan.hasNextLine()) {
            graphList.add(graphScan.nextLine());
        }
        graphFile = graphList.toArray(new String[0]);
        return graphFile;

    }

    public void addEdge(int source, int destination) {
        int valueToAdd = 1;
        
        matrix[destination][source] = valueToAdd;
        isMatrix[source][destination] = true;

        
        matrix[destination][source] = valueToAdd;
        isMatrix[destination][source] = true;
        
    }
    



    public static ArrayList<Integer> findEdges(String[] arr) throws FileNotFoundException {
        
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].contains("add edge")) {
                arr[i] = arr[i].replaceAll("[^0-9]", "");
                String[] vertexArray = arr[i].trim().split("");
                intArray = new int[vertexArray.length];
                for (int j = 0; j < vertexArray.length; j++) {
                    //intArray[j] = Integer.parseInt(vertexArray[j]);
                    //numList.add(intArray[j]);
                    System.out.println(vertexArray[j]);
                }
            }
            
        } 
        return numList;
    }

   public static ArrayList<Integer> findVertex(String[] arr) throws FileNotFoundException {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].contains("add vertex")) {
                arr[i] = arr[i].replaceAll("[^0-9]", " ").trim(); //.split(" ")
                String[] vertexArray = arr[i].trim().split(" "); 
                intArray = new int[vertexArray.length];
                for (int j = 0; j < vertexArray.length; j++) {
                    intArray[j] = Integer.parseInt(vertexArray[j]);
                    numList.add(intArray[j]);
                                       
                }
            }    
        }
        return numList;
        
       
         
    }
    public static ArrayList<Integer> firstGraph = new ArrayList<Integer>();
    public static ArrayList<Integer> findFirstGraphVertex(ArrayList<Integer> list) {
        for (int i = 0; i < 7; i++) {
            
            firstGraph.add(list.get(i));
        }
        return firstGraph;
    }

    public static void findFirstGraphEdges(ArrayList<Integer> list) {
        for (int i = 0; i < 1; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> edge, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            edge.get(list.get(i)).add(list.get(i + 1));
            edge.get(list.get(i + 1)).add(list.get(i));
        }
        //edge.get(u).add(v);
        //edge.get(v).add(u);
    }

    
  

    public static void main(String[] args) throws Exception {
       
        findFile();
        //newFindVertex(test);
        findVertex(test);
        //findFirstGraphVertex(numList);
        
        
        
    }
}
