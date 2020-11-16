package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoRead {

    String[] graphFile;
    int vertexInt;
    ArrayList<Integer> vertexIntList = new ArrayList<Integer>();

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
}
