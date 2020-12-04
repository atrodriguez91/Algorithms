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

    public String findSpiceInfo(String[] preparedSpice) {
        String test = "";
        String test1 = "";
        String test2 = "";
        String test3 = "";
        for (int i = 0; i < preparedSpice.length; i++) {
            if(preparedSpice[i].endsWith(";")) {
                //System.out.println(preparedSpice[i]);
                if(preparedSpice[i].substring(i).contains("red")) {
                    
                    //test = preparedSpice[i];
                    //return test;
                } else if (preparedSpice[i].substring(i).contains("green")) {
                    
                    test1 = preparedSpice[i];
                    return test1;
                } else if (preparedSpice[i].substring(i).contains("blue")) {
                    
                    //test2 = preparedSpice[i];
                    //return test2;
                } else if (preparedSpice[i].substring(i).contains("orange")) {
                    
                    //test3 = preparedSpice[i];
                    //return test3;
                }
            }
        }
        return test1;
        
    }
    
    public double findPrice(String string) {

        String delim = "[ ;]";
        double totalPrice = 0;
        String [] price = string.split(delim);
        for (int i = 0; i < price.length; i++) {
            if (price[i].contains("total_price")) {
                //System.out.println(price[i + 2]);
                totalPrice = Double.parseDouble(price[i + 2]);
            }
        }
        return totalPrice;
    }

    public int findQty(String string) {
        String delim = "[ ;]";
        int totQty = 0;
        String [] qty = string.split(delim);
        for (int i = 0; i < qty.length; i++) {
            if (qty[i].contains("qty")) {
                totQty = Integer.parseInt(qty[i + 2]);
            }
        }
        return totQty;
    }

    public void findKnapsack(String[] preparedSpice) {
        
        
        for (int i = 0; i < preparedSpice.length; i++) {
            if (preparedSpice[i].contains("knapsack capacity")) {
                preparedSpice[i] = preparedSpice[i].replaceAll("[^0-9]", "");
            }
        }
        
    
    }

    public static void main(String[] args) throws FileNotFoundException {
        GreedySpice s = new GreedySpice();
        String[] a = s.spiceFinder();
        String b = s.findSpiceInfo(a);
        //System.out.println(s.findPrice(b));
        //System.out.println(s.findQty(b));
        s.findKnapsack(a);
    }
}