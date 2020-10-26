

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

    public static int linear(String[] magicArray, String x) {
        for (int i = 0; i < magicArray.length; i++) {
            if (magicArray[i].equals(x)) {
                return i;
            }   
        }
        return 0;

    }

    public static int binary(String[] magicArray, String x) {
        int left = 0;
        int right = magicArray.length - 1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            int value = x.compareTo(magicArray[mid]);
            if (value == 0) {
                return mid;
            } else if (value > 0) {
                return left = mid + 1;
            } else {
                value = mid - 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        findFile();
        quickSort(magicArray, 0, magicArray.length - 1);
        int result = linear(magicArray, "Robe");
        int bresult = binary(magicArray, "Scale Mail");
        System.out.println("Item is located at index: " + bresult);
    }
}