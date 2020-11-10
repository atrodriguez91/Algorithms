import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Graphs {
    static String[] test;

    public static String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph1.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while(graphScan.hasNextLine()) { 
            
            graphList.add(graphScan.nextLine());
            
        
        }
        test = graphList.toArray(new String[0]);
        return test;
    
    }
    
  

    public static void main(String[] args) throws Exception {
        findVertex(test);
        
    }
}
