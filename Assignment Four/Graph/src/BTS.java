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

    public class Link {
        String target;
        Link left, right;
        public Link(String item) {
            target = item;
            left = right = null;
        }
    }

    Link root;


    public BTS() {
        root = null; 
    }

    public void insert(String target) {
        root = insertItem(root, target);
    }

    Link insertItem(Link root, String target) {
        if (root == null) {
            root = new Link(target);
            return root;
        }

        if (target.compareTo(target) < 0) {
            root.left = insertItem(root.left, target);
        } else if (target.compareTo(root.target) > 0) {
            root.right = insertItem(root.right, target);
        }
        return root;
    }
 
    public void check() {
        checkItem(root);
    }

    public void checkItem(Link root) {
        if (root != null) {
            checkItem(root.left);
            System.out.println(root.target);
            checkItem(root.right);
        }
    }

    public Link conjure(Link root, String target) {
        if (root == null || root.target == target) {
            return root;
        }
        if (root.target.compareTo(target) < 0) {
            return conjure(root.right, target);
        }
        return conjure(root.left, target);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BTS log = new BTS();
        String[] magicLog = log.findFile();

        log.insert("something");
        log.insert("test");
        log.insert("cool");
        log.insert("hello");

        log.check();

        log.conjure(log.root, " ");
        log.check();
        

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
        
        //for (int i = 0; i < randomList.length; i++) {
            
       // }
       //log.conjure(log.root., "Candle of truth" );
        //log.check();
        
    }


}
