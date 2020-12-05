

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

// Greedy approach 
public class Greedy {
    // Credits for flow and error checking from GeeksforGeeks.com. 
    // References to textbook for clarity.
    // Youtube Channel: Abdul Bari. 
    private static double getMaxValue(int[] wt, int[] val, int capacity) {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        // sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });
        // This algorithm mimicks the quick/merge sort algorithms
        // earlier in the semester. Above there is a sort that
        // causes the algorithm to run O(n).
        double totalValue = 0;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            double curVal = (double) i.val;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }
        // Above is how we stuff the back, hence the fractional. 
        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            // The division here is ultimately what gives the fractional
            // knapsack the O(nlogn) asymptotic run time. With each
            // division the algorithm will tackle each portion. 
            cost = (double) val / (double) wt;
        }
    }

    // Driver code for fractional knapsack here
    public static void main(String[] args) throws FileNotFoundException {

        GreedySpice greed = new GreedySpice();
        String[] a = greed.spiceFinder();
        double spice1Price = greed.findPrice(greed.findSpiceInfo(a, "red"), 3);
        double spice2Price = greed.findPrice(greed.findSpiceInfo(a, "green"), 2);
        double spice3Price = greed.findPrice(greed.findSpiceInfo(a, "blue"), 2);
        double spice4Price = greed.findPrice(greed.findSpiceInfo(a, "orange"), 2);
        int spice1qty = greed.findQty(greed.findSpiceInfo(a, "red"));
        int spice2qty = greed.findQty(greed.findSpiceInfo(a, "green"));
        int spice3qty = greed.findQty(greed.findSpiceInfo(a, "blue"));
        int spice4qty = greed.findQty(greed.findSpiceInfo(a, "orange"));
        int spiceCap1 = greed.findKnapsack(a, "1");
        int spiceCap2 = greed.findKnapsack(a, "6");
        int spiceCap3 = greed.findKnapsack(a, "10");
        int spiceCap4 = greed.findKnapsack(a, "20");
        int spiceCap5 = greed.findKnapsack(a, "21");

        int[] wt = { spice1qty, spice2qty, spice3qty, spice4qty }; 
        int[] val = { (int)spice1Price, (int)spice2Price, (int)spice3Price, (int)spice4Price  }; 
        int capacity1 = spiceCap1 ;
        int capacity2 = spiceCap2 ;
        int capacity3 = spiceCap3 ;
        int capacity4 = spiceCap4 ;
        int capacity5 = spiceCap5 ;

        

       
  
        double maxValue = getMaxValue(wt, val, capacity1);
        double maxValue2 = getMaxValue(wt, val, capacity2);
        double maxValue3 = getMaxValue(wt, val, capacity3);
        double maxValue4 = getMaxValue(wt, val, capacity4);
        double maxValue5 = getMaxValue(wt, val, capacity5); 
        
        // Function call 
        System.out.println("Knapsack of capacity " + capacity1 + " is worth " + 
        maxValue);
        System.out.println("Knapsack of capacity " + capacity2 + " is worth " + 
        maxValue2);
        System.out.println("Knapsack of capacity " + capacity3 + " is worth " + 
        maxValue3);
        System.out.println("Knapsack of capacity " + capacity4 + " is worth " + 
        maxValue4);
        System.out.println("Knapsack of capacity " + capacity5 + " is worth " + 
        maxValue5);
         
    } 
}