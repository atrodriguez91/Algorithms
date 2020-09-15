package Algorithms.src;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Read {

    public static void main(String[] args) throws IOException{
        String theString = "";

        File file = new File("magicitems.txt");
        Scanner scanner = new Scanner(file);

        theString = scanner.nextLine();
        while (scanner.hasNextLine()) {
            theString = theString + "\n" + scanner.nextLine();
        }

        char[] charArray = theString.toCharArray();

        scanner.close();
        System.out.println(charArray);
    


    }
}


