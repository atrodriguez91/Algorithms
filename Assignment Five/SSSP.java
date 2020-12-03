import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SSSP {
    String[] graphFile;
    String[] edges;
    int vertexInt;
    ArrayList<String> edgeIntList = new ArrayList<String>();
    ArrayList<String> edgeIntList1 = new ArrayList<String>();
    ArrayList<String> edgeIntList2 = new ArrayList<String>();
    ArrayList<Integer> vertexIntList = new ArrayList<Integer>();
    public String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph2.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while (graphScan.hasNextLine()) {
            graphList.add(graphScan.nextLine());
        }
        graphFile = graphList.toArray(new String[0]);
        return graphFile;

    }

    public ArrayList<Integer> getVertex(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("add vertex")){
                arr[i] = arr[i].replaceAll("[^0-9]", " ").trim();
                vertexInt = Integer.parseInt(arr[i]);
                vertexIntList.add(vertexInt);
            }
        }
        return vertexIntList; 
    }

    public List<String> getEdgesFirst(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("add edge")) {
             arr[i] = arr[i].replaceAll("[^0-9]", " ").trim();
             edges = new String[arr.length];
             edges[i] = (String) arr[i].subSequence(0, 2);
             edgeIntList.add(edges[i]);
            }
        }
        List<String> trim1 = edgeIntList.stream().map(String::trim).collect(Collectors.toList());
        return trim1;
    }

    public List<String> getEdgesSecond(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("add edge")) {
             arr[i] = arr[i].replaceAll("[^0-9]", " ").trim();
             edges = new String[arr.length];
             edges[i] = (String) arr[i].substring(3, 5);
             edgeIntList1.add(edges[i]);
            }
        }
        List<String> trim = edgeIntList1.stream().map(String::trim).collect(Collectors.toList());
        return trim;
    }

    public List<String> getEdgesWeight(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("add edge")) {
             arr[i] = arr[i].replaceAll("[^0-9]", "").trim();
             edges = new String[arr.length];
             edges[i] = (String) arr[i].substring(2, 3);
             edgeIntList2.add(edges[i]);
            }
        }
        List<String> trim2 = edgeIntList2.stream().map(String::trim).collect(Collectors.toList());
        return trim2;
    }
    public static void main(String[] args) throws FileNotFoundException {
        SSSP n = new SSSP();
        String[] a = n.findFile();
        System.out.println(n.getEdgesWeight(a));
        
    }
}
