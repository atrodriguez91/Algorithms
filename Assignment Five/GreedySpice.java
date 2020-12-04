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

    public String findSpiceInfo(String[] preparedSpice, String color) {
        String spice = "";
        for (int i = 0; i < preparedSpice.length; i++) {
            if(preparedSpice[i].endsWith(";")) {
                //System.out.println(preparedSpice[i]);
                if(preparedSpice[i].substring(i).contains(color)) {
                    spice = preparedSpice[i];
                    return spice;
                } 
            }
        }
        return spice;
    }
    
    public double findPrice(String string, int flag) {

        String delim = "[ ;]";
        double totalPrice = 0;
        String [] price = string.split(delim);
        for (int i = 0; i < price.length; i++) {
            if (price[i].contains("total_price")) {
                //System.out.println(price[i + 2]);
                totalPrice = Double.parseDouble(price[i + flag]);
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

    public int findKnapsack(String[] preparedSpice, String selection) {
        String capacity = "";
        int capacity1 = 0;
        
        for (int i = 0; i < preparedSpice.length; i++) {
            if (preparedSpice[i].contains("knapsack capacity")) {
                if (preparedSpice[i].substring(i).contains(selection)) {
                    capacity = preparedSpice[i].replaceAll("[ =a-z;]", "");
                    capacity1 = Integer.parseInt(capacity);
                }
            }
        }
        return capacity1;
    
    }

    public static void main(String[] args) throws FileNotFoundException {
        GreedySpice s = new GreedySpice();
        String[] a = s.spiceFinder();
        
        
        System.out.println(s.findPrice(s.findSpiceInfo(a, "blue"), 2)); //Price
        System.out.println(s.findQty(s.findSpiceInfo(a, "blue")));      //Quantity
        System.out.println(s.findKnapsack(a, "6"));
    }
}