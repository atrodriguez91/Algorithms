

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    static int linearComparisons;
    public static int linear(String[] magicArray, String x) {
        for (int i = 0; i < magicArray.length; i++) {
            linearComparisons++;
            if (magicArray[i].equals(x)) {
                linearComparisons++;;
                return i;
                
            }
             
              
        }
        
        return 0;

    }
    static int comparisons = 0;
    public static int binary(String[] magicArray, String x) {
        int left = 0;
        int right = magicArray.length - 1;
        while (left <= right) {
            
            comparisons++;

            int mid = left + (right - left) / 2;
            int val = x.compareTo(magicArray[mid]);
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

        for (int i = 0; i < randomList.length; i++) {
            int result1 = linear(magicArray, randomList[i]);
            System.out.println(randomList[i] + " is located at index: " + result1);
            System.out.println("Count is: " + linearComparisons);
        }

        int average = linearComparisons / 42;
        System.out.println("The average count is: " + average);


        //String x = "Robe";
        //int result = binary(magicArray, x);
        //System.out.println("Item is located at index: " + result);
        //System.out.println("Count is: " + comparisons);
    }
}