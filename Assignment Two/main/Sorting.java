package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
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

    public static void selectionSort() throws FileNotFoundException {
        findFile();
        for (int i = 0; i < magicArray.length; i++) {
            int spot = i;
            String low = magicArray[i];
            for (int j = i + 1; j < magicArray.length; j++) {
                if (magicArray[j].compareTo(low) < 0) {
                    spot = j;
                    low = magicArray[j];
                }
            }

            magicArray[spot] = magicArray[i];
            magicArray[i] = low;
        }
    }

    public static void insertionSort() throws FileNotFoundException {
        findFile();
        for ( int i = 1; i < magicArray.length; i++) {
            String sortedMagic = magicArray[i];

            int j = i;
            while (j > 0 && magicArray[j -1].compareTo(sortedMagic) > 1) {
                magicArray[j] = magicArray[j-1];
                j--;
            }
            magicArray[j] = sortedMagic;
        }
        
    }

    public static void merge(String[] magicArray, String[] left, String[] right) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < magicArray.length; i++) {
            if (y >= right.length || (x < left.length && left[x].compareToIgnoreCase(right[y]) < 0)) {
                magicArray[i] = left[x];
                x++;
            } else {
                magicArray[i] = right[y];
                y++;
            }
        }
    }

    public static void mergeSort(String[] magicArray) {
        if (magicArray.length > 1) {
            // Creation of the left and right components of the array
            // this divides and allows the divide and conquer approach
            String[] left = new String[magicArray.length / 2];
            String[] right = new String[magicArray.length - magicArray.length / 2];
            //Iterate through the left array and init 
            for (int i = 0; i < left.length; i++) {
                left[i] = magicArray[i];
            }
            //Iterate through the right to get mid
            for (int i = 0; i < right.length; i++) {
                right[i] = magicArray[i + magicArray.length / 2];
            }
            //Last method to merge the left and right
            mergeSort(left);
            mergeSort(right);
            merge(magicArray, left, right);
        }
    }

    public static void flip(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static String[] quickSort(String[] a, int start, int end) {
        
        int i = start;
        int j = end;

        if (j - i >= 1) {
            String axle = a[i];
            while (j > i) {
                while (a[i].compareTo(axle) <= 0 && i < end && j > i) {
                    i++;
                }
                while (a[j].compareTo(axle) >= 0 && j > start && j >= i) {
                    j--;
                }
                if (j > i) {
                    flip(a, i, j);
                }

                flip(a, start, j);
                quickSort(a, start, j - 1);
                quickSort(a, j + 1, end);
            }
        }
        return magicArray;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Base print of the array to compare later results to. 
        findFile();
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }
//-------------------------------------------------------------------------
        System.out.println("\n");
        System.out.println("Now Sorting...");
        System.out.println("\n");
//-------------------------------------------------------------------------
        // Below are the different sorting methods. Uncomment each to use
        // and test. Running multiple will get you a mess more magical
        // than any array can provide. Guaranteed. 
// ---- SORTING METHODS BELOW ----

        //selectionSort();
        //insertionSort();
        mergeSort(magicArray);

// Print to term with the newly assorted array
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }
    }
}

        