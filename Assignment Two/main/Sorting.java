package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    static String[] magicArray;

    public static String[] findFile() throws FileNotFoundException {
        // Taking the magical items and throwing them
        // into the magicList. 
        Scanner magicScan = new Scanner(new File("magicitems.txt"));

        ArrayList<String> magicList = new ArrayList<String>();

        while (magicScan.hasNext()) {
            magicList.add(magicScan.nextLine());
        }

        // Taking the magical list and throwing them
        // into a magical array from which the rest 
        // of the program will use for neat tricks.

        magicArray = magicList.toArray(new String[0]);

        return magicArray;

    }
// ---- METHOD TO CHECK COMPARISONS ---- //
    public static void comparisons(String[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                // Iterate through the inner loop to find the comparisons
                // Since we are comparing the arrays below. 
                if ((arr[j].compareTo(arr[j + 1]) < 0)) { 
                    String[] temp = arr[j].split("");
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp.toString();
                    count++;
                }
            }
        }
        System.out.print("\n\nComparisons: " + count);
    }
// ---- SELECTION SORT ---- //

    public static void selectionSort() throws FileNotFoundException {
        findFile(); // Bringing the array in using a method
        // First FOR loop iterates through the array
        // Designates first index as starting point
        for (int i = 0; i < magicArray.length; i++) {
            int spot = i; // Starting point
            String low = magicArray[i]; // Init to first element
            for (int j = i + 1; j < magicArray.length; j++) {
                // Comparing the strings lexicographyically
                // Set the IF statement if one string is less
                // than the other for the comparison
                if (magicArray[j].compareTo(low) < 0) {
                    spot = j;
                    low = magicArray[j];
                }
            }
            // Make the swap once the string with 
            // the lesser value is found
            magicArray[spot] = magicArray[i];
            magicArray[i] = low;
        }
        // Finally we pass the sorted array 
        // into our comparisons loop to count 
        // comparions
        comparisons(magicArray);
    }
// ---- INSERTION SORT ---- //

    public static void insertionSort() throws FileNotFoundException {
        findFile();
        // We are to iterate over the array
        // and compare each element with the one
        // before it. 
        for ( int i = 1; i < magicArray.length ; i++) {
            // sortedMagicElement will be the element of the array
            // that will be used to compare to the element
            // before it. 
            String sortedMagicElement = magicArray[i];
            int j = i - 1 ;
            // Shift the element up a notch 
            // if more magical than sortedMagic.
            while (j >= 0 && magicArray[j].compareTo(sortedMagicElement) > 1) {
                magicArray[j] = magicArray[j + 1];
                j = j + 1;
            }
            // Moves new sortedMagicElement up 
            // and start again
            magicArray[j + 1] = sortedMagicElement;
        }

        comparisons(magicArray);
        
    }
// ---- MERGE SORT ----//

    public static void merge(String[] magicArray, String[] left, String[] right) {
        // Set up to merge the two halves of the array together
        int x = 0;
        int y = 0;
        for (int i = 0; i < magicArray.length; i++) {
            if (y >= right.length || (x < left.length && left[x].compareTo(right[y]) < 0)) {
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
            // Merge left and right back into our magicalArray
            merge(magicArray, left, right);
        }

        //comparisons(magicArray);
    }

    public static void qSort() {
        int left = 0;
        int right = magicArray.length - 1;

        quickSort(left, right);
    }

    public static void quickSort(int left, int right) {
        if (left >= right){
            return;
        }

        String magicalPivot = conjureBarrier(left, right);
        int magicBarrier = magicBarrier(left, right, magicalPivot);

        quickSort(0, magicBarrier -1);
        quickSort(magicBarrier + 1, right);
    }

    public static int magicalBarrier(int left, int right, String magicalPivot) {
        int leftEnd = left - 1;
        int rightEnd = right;
        while (leftEnd < rightEnd) {
            while(((Comparable<String>)magicalArray[++leftEnd]).compareTo(magicalPivot) < 0);

        }
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

// ---- Uncomment below to see the sorted list in action ----
// ---- SORTED LIST/ARRAY BELOW ----

// Print to term with the newly assorted array
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }
    }
}