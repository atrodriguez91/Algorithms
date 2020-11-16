package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class BTS {

    String[] magicFile;
    
    public String[] findFile() throws FileNotFoundException {
        Scanner magicScan = new Scanner(new File("magicitems.txt"));
        ArrayList<String> magicList = new ArrayList<String>();
        while (magicScan.hasNextLine()) {
            magicList.add(magicScan.nextLine());
        }
        magicFile = magicList.toArray(new String[0]);
        return magicFile;

    }



}
