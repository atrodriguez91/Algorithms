package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InfoRead {

    String[] graphFile;
    String[] edges;
    int vertexInt;
    ArrayList<String> edgeIntList = new ArrayList<String>();
    ArrayList<String> edgeIntList1 = new ArrayList<String>();
    ArrayList<Integer> vertexIntList = new ArrayList<Integer>();
    // File reader 
    public String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph1.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while (graphScan.hasNextLine()) {
            graphList.add(graphScan.nextLine());
        }
        graphFile = graphList.toArray(new String[0]);
        return graphFile;

    }

    //GETTING VERTEX INFORMATION
    // Compile ALL vertices from the file. 

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
    // VERTEX FOR EACH GRAPH (Only way I could make it work)
    public List<Integer> firstGraphV(ArrayList<Integer> list){
        List<Integer> firstGraphVL = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            firstGraphVL.add(list.get(i));
        }
        return firstGraphVL;
    }

    public List<Integer> secondGraphV(ArrayList<Integer> list) {
        ArrayList<Integer> secondGraphVL = new ArrayList<Integer>();
        for (int i = 7; i < 15; i++) {
            secondGraphVL.add(list.get(i));
        }
        return secondGraphVL;
    }
    public ArrayList<Integer> thirdGraphV(ArrayList<Integer> list){
        ArrayList<Integer> thirdGraphVL = new ArrayList<Integer>();
        for (int i = 15; i < 78; i++) {
            thirdGraphVL.add(list.get(i));
        }
        return thirdGraphVL;
    }
    public ArrayList<Integer> fourthGraphV(ArrayList<Integer> list){
        ArrayList<Integer> fourthGraphVL = new ArrayList<Integer>();
        for (int i = 78; i < 142; i++) {
            fourthGraphVL.add(list.get(i));
        }
        return fourthGraphVL;
    }
    public ArrayList<Integer> fifthGraphV(ArrayList<Integer> list){
        ArrayList<Integer> fifthGraphVL = new ArrayList<Integer>();
        for (int i = 142; i < 163; i++) {
            fifthGraphVL.add(list.get(i));
        }
        return fifthGraphVL;
    }
    //================================================================
    // This collects the first source edges of the file. 
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
    // Collects the destination edges of the file. 
    public List<String> getEdgesSecond(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("add edge")) {
             arr[i] = arr[i].replaceAll("[^0-9]", "  ").trim();
             edges = new String[arr.length];
             edges[i] = (String) arr[i].substring(4);
             edgeIntList1.add(edges[i]);
            }
        }
        List<String> trim = edgeIntList1.stream().map(String::trim).collect(Collectors.toList());
        return trim;
    }
    //==============================================================================================
    // Grabs either src/dest edges and separates them according to individual graph.
    public List<Integer> firstGraphE(List<String> list) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            intList.add(Integer.valueOf(list.get(i)));
        }
        return intList;
    }
    public List<Integer> secondGraphE(List<String> list) {
        List<Integer> intList1 = new ArrayList<Integer>();
        for (int i = 11; i < 39; i++) {
            intList1.add(Integer.valueOf(list.get(i)));
        }
        return intList1;
    }
    public List<Integer> thirdGraphE(List<String> list) {
        List<Integer> intList2 = new ArrayList<Integer>();
        for (int i = 39; i < 101; i++) {
            intList2.add(Integer.valueOf(list.get(i)));
        }
        return intList2;
    }
    public List<Integer> fourthGraphE(List<String> list) {
        List<Integer> intList3 = new ArrayList<Integer>();
        for (int i = 101; i < 173; i++) {
            intList3.add(Integer.valueOf(list.get(i)));
        }
        return intList3;
    }
    public List<Integer> fifthGraphE(List<String> list) {
        List<Integer> intList4 = new ArrayList<Integer>();
        for (int i = 173; i < 198; i++) {
            intList4.add(Integer.valueOf(list.get(i)));
        }
        return intList4;
    }
}
