import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GreedySpice {
    String[] preparedSpice = {""};
    public String[] spiceFinder() throws FileNotFoundException {
        Scanner spiceScan = new Scanner(new File("spice.txt"));
        ArrayList<String> spiceInput = new ArrayList<String>();
        while (spiceScan.hasNextLine()) {
            spiceInput.add(spiceScan.nextLine());
        }
        preparedSpice = spiceInput.toArray(new String[0]);
        return preparedSpice;
    }

    public ArrayList<String> findSpiceInfo(String[] preparedSpice) {
        ArrayList<String> b = new ArrayList<String>();
        for (int i = 0; i < preparedSpice.length; i++) {
           if (preparedSpice[i].contains("spice name = ")) {
                b.add(preparedSpice[i]);
            } 
        }
        return b;
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        GreedySpice s = new GreedySpice();
        String[] a = s.spiceFinder();
        ArrayList<String> b = s.findSpiceInfo(a);
        System.out.println(b);
    }
}