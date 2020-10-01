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

        // Takingthe magical list and throwing them
        // into a magical array from which the rest 
        // of the program will use for neat tricks.

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
            while (((Comparable<String)a))
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

// Print to term with the newly assorted array
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }
    }
}