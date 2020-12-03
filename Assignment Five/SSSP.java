import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SSSP {
    String[] graphFile;
    public String[] findFile() throws FileNotFoundException {
        Scanner graphScan = new Scanner(new File("graph2.txt"));
        ArrayList<String> graphList = new ArrayList<String>();
        while (graphScan.hasNextLine()) {
            graphList.add(graphScan.nextLine());
        }
        graphFile = graphList.toArray(new String[0]);
        return graphFile;

    }
}
