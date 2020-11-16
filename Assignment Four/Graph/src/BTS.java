package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class BTS {
    // Credit: Examples from textbook / YouTube and GeeksForGeeks.com.
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

    public static class Node {
        String data;
        Node left, right;
    }

    public static Node newN(String item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static int count = 0;
    public static boolean search(Node root, String target) {
        while (root != null) {
            if (target.compareTo(root.data) > 0) {
                root = root.right;
                count++;
            } else if (target.compareTo(root.data) < 0) {
                root = root.left;
                count++;
            } else {
                return true;
            }
            
        }
        return false;
    }

    public static Node insert(Node Node, String data) {
        if (Node == null) {
            return newN(data);
        }
        if (data.compareTo(Node.data) < 0) {
            Node.left = insert(Node.left, data);
        } else if (data.compareTo(Node.data) > 0) {
            Node.right = insert(Node.right, data);
        }
        return Node;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BTS b = new BTS();
        
        String[] m = b.findFile();
        Node root = null;
        root = insert(root, "Sword Scabbard of Hiding");
        for (int i = 0; i < m.length; i++) {
            insert(root, m[i]);
        }

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
            search(root, randomList[i]);

        }
        System.out.println(count);
        System.out.println("Overall AVG is: " + count / 42);
        
        
    }


}
