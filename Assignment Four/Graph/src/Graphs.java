import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





public class Graphs {
    public static String[] test;
    public static String[] vertexArray;
    public static String[] newArray;
    public static int [] intArray;
    public static ArrayList<Integer> numList = new ArrayList<Integer>();
    public static String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph1.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while (graphScan.hasNextLine()) {

            graphList.add(graphScan.nextLine());

        }
        test = graphList.toArray(new String[0]);
        return test;

    }

    

    public static ArrayList<Integer> findEdges(String[] arr) throws FileNotFoundException {
        
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].contains("add edge")) {
                arr[i] = arr[i].replaceAll("[^0-9]", " ").trim();
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

    public static void parseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
    }
  

    public static void main(String[] args) throws Exception {
       
        findFile();
        
        System.out.println(findEdges(test));
        
        
    }
}
