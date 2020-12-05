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
    int graph1 = 5;
    int graph2, graph3, graph4 = 7;
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

    public List<Integer> firstGraphV(ArrayList<Integer> list){
        List<Integer> firstGraphVL = new ArrayList<Integer>();
        for (int i = 0; i < graph1; i++) {
            firstGraphVL.add(list.get(i));
        }
        return firstGraphVL;
    }

    public List<Integer> secondGraphV(ArrayList<Integer> list) {
        ArrayList<Integer> secondGraphVL = new ArrayList<Integer>();
        for (int i = graph1; i < 12; i++) {
            secondGraphVL.add(list.get(i));
        }
        return secondGraphVL;
    }

    public ArrayList<Integer> thirdGraphV(ArrayList<Integer> list){
        ArrayList<Integer> thirdGraphVL = new ArrayList<Integer>();
        for (int i = 12; i < 19; i++) {
            thirdGraphVL.add(list.get(i));
        }
        return thirdGraphVL;
    }

    public ArrayList<Integer> fourthGraphV(ArrayList<Integer> list){
        ArrayList<Integer> fourthGraphVL = new ArrayList<Integer>();
        for (int i = 19; i < 26; i++) {
            fourthGraphVL.add(list.get(i));
        }
        return fourthGraphVL;
    }
//========================================================================
    public List<Integer> firstGraphE(List<String> list) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            intList.add(Integer.valueOf(list.get(i)));
        }
        return intList;
    }
    public List<Integer> secondGraphE(List<String> list) {
        List<Integer> intList1 = new ArrayList<Integer>();
        for (int i = 10; i < 22; i++) {
            intList1.add(Integer.valueOf(list.get(i)));
        }
        return intList1;
    }
    public List<Integer> thirdGraphE(List<String> list) {
        List<Integer> intList2 = new ArrayList<Integer>();
        for (int i = 22; i < 34; i++) {
            intList2.add(Integer.valueOf(list.get(i)));
        }
        return intList2;
    }
    public List<Integer> fourthGraphE(List<String> list) {
        List<Integer> intList3 = new ArrayList<Integer>();
        for (int i = 34; i < 46; i++) {
            intList3.add(Integer.valueOf(list.get(i)));
        }
        return intList3;
    }
    public static void main(String[] args) throws FileNotFoundException {
        SSSP n = new SSSP();
        String[] a = n.findFile();
        System.out.println(n.firstGraphE(n.getEdgesWeight(a)));
        
        
    }
}
