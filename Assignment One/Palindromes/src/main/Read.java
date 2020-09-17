package main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import main.SelfStack;

public class Read {

    public static void main(String[] args) throws IOException{
        String line = "";

        //Scan the file
        Scanner file = new Scanner (new File("magicitems.txt"));
        

        List<String> newList = new ArrayList<String>();


        while (file.hasNext()) {
            line = file.next();
            newList.add(line);
        }

        file.close();

        SelfStack<String> stack = new SelfStack<String>();
        stack.push(newList);
        Queue q = new Queue(100);
        q.enqueue((ArrayList<String>) newList);

        if (stack.peek() != q.peek()) {
            stack.pop();
            q.dequeue();
            System.out.println(stack.peek() + q.dequeue());
        }

        System.out.println(stack.peek());
        //System.out.println(q.peek());

        
        


        

    }
}


