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

    public void findSpiceInfo(String[] preparedSpice) {
        ArrayList<String> red = new ArrayList<String>();
        ArrayList<String> green = new ArrayList<String>();
        ArrayList<String> blue = new ArrayList<String>();
        ArrayList<String> orange = new ArrayList<String>();
        String [] test;
        String totalPrice = "";
        for (int i = 0; i < preparedSpice.length; i++) {
            if(preparedSpice[i].endsWith(";")) {
                //System.out.println(preparedSpice[i]);
                if(preparedSpice[i].substring(i).contains("red")) {
                    red.add(preparedSpice[i]);
                    test = new String[preparedSpice.length];
                    test[i] = preparedSpice[i];
                   
                    //System.out.println(test[i]);
                } else if (preparedSpice[i].substring(i).contains("green")) {
                    green.add(preparedSpice[i]);
                    //System.out.println(green);
                } else if (preparedSpice[i].substring(i).contains("blue")) {
                    blue.add(preparedSpice[i]);
                    //System.out.println(blue);
                } else if (preparedSpice[i].substring(i).contains("orange")) {
                    orange.add(preparedSpice[i]);
                    //System.out.println(orange);
                }
            }
        }
        for (int i = 0; i < test.length; i++) {
            
        }
        
    }

    public ArrayList<String> findKnapsack(String[] preparedSpice) {
        ArrayList<String> c = new ArrayList<String>();
        for (int i = 0; i < preparedSpice.length; i++) {
            if (preparedSpice[i].contains("knapsack ")) {
                c.add(preparedSpice[i]);
            }
        }
        return c;
    }


    public static void main(String[] args) throws FileNotFoundException {
        GreedySpice s = new GreedySpice();
        String[] a = s.spiceFinder();
        s.findSpiceInfo(a);
    }
}