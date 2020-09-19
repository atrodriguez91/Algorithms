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
        //System.out.println(q.peek());

        
        


        

    }
}


