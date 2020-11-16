package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
}
