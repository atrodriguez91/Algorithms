package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {
    static String[] magicArray;

    public static String[] Sorting() throws FileNotFoundException {
        Scanner magicScan = new Scanner(new File("magicitems.txt"));

        ArrayList<String> magicList = new ArrayList<String>();

        while (magicScan.hasNext()) {
            magicList.add(magicScan.nextLine());
        }

        magicArray = magicList.toArray(new String[0]);

        return magicArray;

    }

    public static void selectionSort() throws FileNotFoundException {
        Sorting();
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

    public static void main(String[] args) throws FileNotFoundException {
        Sorting();
        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }

        selectionSort();
        System.out.println("\n");
        System.out.println("Now Sorting...");
        System.out.println("\n");

        for (int i = 0; i < magicArray.length; i++) {
            System.out.println(magicArray[i] + " ");
        }
    }
}

        