package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException{
        //Variable to store String
        String line = "";

        //Scan the file using a scanner for data capture
        Scanner file = new Scanner (new File("magicitems.txt"));
        
        //Place the contents of the data into an array
        List<String> newList = new ArrayList<String>();

        //While loop to cycle through data and store into "line" variable
        //Adds the lines into a newList
        while (file.hasNext()) {
            line = file.next();
            newList.add(line);
        }

        file.close();
        // Creation of stack and queue instance 
        SelfStack<String> stack = new SelfStack<String>();
        stack.push(newList);
        Queue q = new Queue(100);
        q.enqueue((ArrayList<String>) newList);

        if (stack.peek() != q.peek()) { 
            stack.pop();
            q.dequeue();
            
        }

        System.out.println(stack.peek());
        
        //Still not done. Got confused with String to Char and to properly push onto a stack and enqueue. 
        // Would then compare stack.pop == q.enqueue then SYSout the words that were palindromes.
        // My fault, didn't manage my time effectively. 
        // Will continue to work on regardless. 
        // I accept that I am at your mercy. 

        
        


        

    }
}


