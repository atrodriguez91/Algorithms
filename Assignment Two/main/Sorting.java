package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public static String[] selectionSort() throws FileNotFoundException {
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
        //comparisons(magicArray);
        return magicArray;
    }
// ---- INSERTION SORT ---- //

    public static String[] insertionSort() throws FileNotFoundException {
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

        //comparisons(magicArray);
        return magicArray;
        
    }
// ---- MERGE SORT ----//

    public static void merge(String[] magicArray, String[] left, String[] right) {
        // Set up to merge the two halves of the array together
        int x = 0;
        int y = 0;
        for (int i = 0; i < magicArray.length; i++) {
            // Comparison between the left anf right arrays to determine
            // element order. If the index of the left array finds unsorted
            // elements, sort them and increase the counter. 
            // Otherwise, take the right array and merge to the main array.
            if (y >= right.length || (x < left.length && left[x].compareTo(right[y]) < 0)) {
                magicArray[i] = left[x];
                x++;
            } else {
                magicArray[i] = right[y];
                y++;
            }
        }
    }

    public static String[] mergeSort(String[] magicArray) {
        if (magicArray.length > 1) {
            // Creation of the left and right components of the array
            // this divides and allows the divide and conquer approach
            String[] left = new String[magicArray.length / 2];
            String[] right = new String[magicArray.length - magicArray.length / 2];
            // Iterate through the left array and start
            // from the very beginning
            for (int i = 0; i < left.length; i++) {
                left[i] = magicArray[i];
            }
            //Iterate through the right half of the array
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
        return magicArray;
    }
// ---- QUICKSORT METHOD ---- //

    public static int magicalPartition(String[] arr, int behind, int top) {
        // This is the point of reference. Using the topmost 
        // element for comparisons
        String mPivot = arr[top];
        // Creates a partition at the very end and 
        // refers to the element right behind it. 
        int i = behind - 1;
        for (int j = behind; j < top; j++) {
            if (arr[j].compareTo(mPivot) < 0) {
                i++;
                String swap = arr[i]; // 
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
        if (behind < top) {
            int part = magicalPartition(arr, behind, top);

            quickSort(arr, behind, part - 1);
            quickSort(arr, part + 1, top);
        }

        //comparisons(magicArray);
        return magicArray;
    }
    

    public static void main(String[] args) throws FileNotFoundException {
        // Base print of the array to compare later results to. 
        findFile();
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }

        System.out.println("\nSELECT YOUR SORT: ");
        System.out.println("SELECT SORT: PRESS 1 (List), PRESS 2 (Comparisons)");
        System.out.println("INSERT SORT: PRESS 3 (List), PRESS 4 (Comparisons)");
        System.out.println("MERGE SORT:  PRESS 5 (List), PRESS 6 (Comparisons)");
        System.out.println("QUICK SORT:  PRESS 7 (List), PRESS 8 (Comparisons)");
        Scanner input = new Scanner(System.in);
        
        int entry = input.nextInt();
        // Display SORTED SELECTion list ----------------
        if (entry == 1) {
            System.out.println("\n");
            System.out.println("Now Sorting...");
            System.out.println("\n");
            selectionSort();
            for (int i = 0; i < magicArray.length; i++) {
                System.out.println(magicArray[i] + " ");
            } 
            input.close();
            return; 
            // SELECTion sort comparisons ---------------
        } else if (entry == 2) {
            System.out.println("Generating Comparisons");
            comparisons(selectionSort());
            // Display SORTED INSERTion list ------------
        } else if (entry == 3) {
            System.out.println("\n");
            System.out.println("Now Sorting...");
            System.out.println("\n");
            insertionSort();
            for (int i = 0; i < magicArray.length; i++) {
                System.out.println(magicArray[i] + " ");
            }
            input.close();
            return;
            // INSERTion sort comparisons ---------------
        } else if (entry == 4) {
            System.out.println("Generating Comparisons");
            comparisons(insertionSort());
            // Display SORTED MERGE list ----------------
        } else if (entry == 5) {
            System.out.println("\n");
            System.out.println("Now Sorting...");
            System.out.println("\n");
            mergeSort(magicArray);
            for (int i = 0; i < magicArray.length; i++) {
                System.out.println(magicArray[i] + " ");
            }
            input.close();
            return;
            // MERGE sort comparisons -------------------
        } else if (entry == 6) {
            System.out.println("Generating Comparisons");
            comparisons(mergeSort(magicArray));
            // Display SORTED QUICK list ----------------
        } else if (entry == 7) {
            System.out.println("\n");
            System.out.println("Now Sorting...");
            System.out.println("\n");
            quickSort(magicArray, 0, magicArray.length - 1);
            for (int i = 0; i < magicArray.length; i++) {
                System.out.println(magicArray[i] + " ");
            }
            input.close();
            return;
            // QUICK sort comparisons -------------------
        } else if (entry == 8) {
            System.out.println("Generating Comparisons");
            comparisons(quickSort(magicArray, 0, magicArray.length - 1));
        }

        input.close();


//-------------------------------------------------------------------------
        //System.out.println("\n");
        //System.out.println("Now Sorting...");
        //System.out.println("\n");
//-------------------------------------------------------------------------
        // Below are the different sorting methods. Uncomment each to use
        // and test. Running multiple will get you a mess more magical
        // than any array can provide. Guaranteed. 

// ---- SORTING METHODS BELOW ----

        //selectionSort();
        //insertionSort();
        //mergeSort(magicArray);
        //quickSort(magicArray, 0, magicArray.length - 1);

// To see sorted list without comparisons: 
//  1. Comment out comparisons() method from desired sort
//  2. Uncomment the below Sysout/FOR loop
//  3. Ensure desired sort is uncommented.
// ---- SORTED LIST/ARRAY BELOW ----

// Print to term with the newly assorted array
        //for (int i = 0; i < magicArray.length; i++) {
        //    System.out.println(magicArray[i] + " ");
        //}
    }
}