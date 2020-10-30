

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Search {
    static String[] magicArray;
    public static String[] findFile() throws FileNotFoundException {
        Scanner magicScan = new Scanner(new File("magicitems.txt"));
        ArrayList<String> magicList = new ArrayList<String>();
        while (magicScan.hasNext()) {
            magicList.add(magicScan.nextLine());
        }
        magicArray = magicList.toArray(new String[0]);
        return magicArray;


    }

    public static int magicalPartition(String[] arr, int behind, int top) {
        // This is the point of reference. Using the topmost 
        // element for comparisons
        String mPivot = arr[top];
        // Creates a partition at the very end and 
        // refers to the element right behind it. 
        int i = behind - 1;
        // The below exchange was modeled from the pseudocode of the 
        // textbook on page 171. It was then compared to an example
        // from GeekstoGeeks.com and modified to pass Strings. 
        for (int j = behind; j < top; j++) {
            if (arr[j].compareTo(mPivot) < 0) {
                i = i + 1;
                String swap = arr[i];  
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        String swap = arr[i + 1];
        arr[i + 1] = arr[top];
        arr[top] = swap;
        return i + 1;
    }

    public static String[] quickSort(String arr[], int behind, int top) {
        // The following was derived straight from the textbook
        // on page 171 from pseudocode. 
        if (behind < top) {
            int part = magicalPartition(arr, behind, top);

            quickSort(arr, behind, part - 1);
            quickSort(arr, part + 1, top);
        }

        //comparisons(magicArray);
        return magicArray;
    }
    // Linear search function with the proper comparisons
    static int linearComparisons;
    // This search iterates through the array with a target 
    // String. Comparisons are counted if an equality between
    // the array and target. 
    // This linear search was self created but used an example
    // on GeekstoGeeks.com to ensure functionality.
    public static int linear(String[] magicArray, String x) {
        for (int i = 0; i < magicArray.length; i++) {
            linearComparisons++;
            if (magicArray[i].equals(x)) {
                linearComparisons++;;
                return i;
                
            }
             
              
        }
        // Flag for testing purposes really.
        return 0;

    }
    static int comparisons = 0;
    // Similar situation here. Used GeekstoGeeks.com for examples
    //of properly functioning code. The binary search divides 
    //the array in half to check if the target value is at mid. 
    // If not, the function checks again whether the target 
    // is lower or above the current index. 
    public static int binary(String[] magicArray, String x) {
        int left = 0;
        int right = magicArray.length - 1;
        while (left <= right) {
            
            comparisons++;
            // Division of the array
            int mid = left + (right - left) / 2;
            //Comparisons of the targe with mid array using
            //String methods. 
            int val = x.compareTo(magicArray[mid]);
            //Below are the expressions to deduce the 
            //String value and to make comparisons 
            //if needed. 
            if (val == 0) {
                comparisons++;
                return mid;
            }
            if (val > 0) {
                comparisons++;
                left = mid + 1;
            } else {
                comparisons++;
                right = mid - 1;
            }
        }
        return 0;
    }

    
    
    public static void main(String[] args) throws FileNotFoundException { 
        findFile();
        quickSort(magicArray, 0, magicArray.length - 1);
        //Above is the sort used from the previous lab. Below is the "random"
        // list chosen from the original. Everything below is original code. 
        String[] randomList = {"Ring of Sin' Sona","Chaos diamond","Sling of Slugging",
        "Instant Armour and Ring", "Cup of Change", "Darkskull", "Aerewens armor",
        "Efreeti bottle", "Sword Scabbard of Hiding", "Healing Totem", "Ring of the Maggot",
        "Foolkiller", "Troll Jar", "Daggers of V", "Eyes of the eagle", "Kings Coinear",
        "Bottle of air", "Hand of Tyr", "Robe", "Robe of Darkness", "Wood Wand", "Helm", 
        "Small Axe", "Candle of truth", "Dust of illusion", "Ring of Air", "Casters Aid", 
        "Chopper", "Wand of Bigby", "The Cup of Life", "Robe of eyes", "Torch Ring",
        "Bowl of Purity", "Eyes of doom", "Dragon Cloak", "Blade", "Belt of Keeping", 
        "Amber Spider", "Tome of leadership and influence", "Morning Star", "Gem of seeing", 
        "Sword of Life"};
        //Formatting skills are better than actual programming. 
        System.out.println("\nLINEAR SEARCH COMPARISONS AND AVERAGE");
        // Below loop iterates through the random list and generates a linear
        // 
        for (int i = 0; i < randomList.length; i++) {
            int result1 = linear(magicArray, randomList[i]);
            System.out.println("[" + randomList[i]+ "]" + " is located at index: " + result1);
            System.out.println("Count is: " + linearComparisons);
        }

        int average = linearComparisons / 42;
        System.out.println("The average count is: " + average);
        System.out.println("\nEND OF LINEAR REPORT");

        System.out.println("\n=========================================");
        System.out.println("\nBINARY SEARCH COMPARISONS AND AVERAGE");
        
        for (int i = 0; i < randomList.length; i++) {
            int result = binary(magicArray, randomList[i]);
            System.out.println("[" + randomList[i] + "]" + " is located at index: " + result);
            System.out.println("Count is: " + comparisons);
        }

        int binaryAverage = comparisons / 42;
        System.out.println("The average count is: " + binaryAverage);
        System.out.println("\nEND OF BINARY REPORT");
        
        HashTableArray<String> table_hash = new HashTableArray<String>(250);
        
        
        String [] some = new String[666];
        for (int i = 0; i < randomList.length; i++) {
            some[i] = randomList[i];
            
        }
        for (int i = 0; i < magicArray.length; i++ ){
            table_hash.put(magicArray[i], i);
            
        }

        for (int i = 0; i < table_hash.size; i++){
            //System.out.println(table_hash.get(magicArray[i]));
            if (Arrays.equals(magicArray, randomList)) {
                table_hash.get(magicArray[i]);
                //System.out.println(table_hash.get(magicArray[i]));
                
            }
        }

        System.out.println(table_hash.moreComparions);

        
        
    }
}
