package main;

import java.util.ArrayList;

//Class with members to set up properties 
//of the queue
public class Queue {
    String[] arr;
    int front;
    int rear;
    int capacity;
    int count;
    //Queue method init 
    Queue(int size) {
        arr = new String[size];
        front = 0;
        rear = -1;
        count = 0;
        capacity = size;
    }
    //Enqueue towards a certain size, parameter is Array
    // Increases count of queue
    public void enqueue(ArrayList<String> newList) {
        rear = (rear + 1) % capacity;
        arr[rear] = newList.toString();
        count++;
        
    }
    //Dequeues and returns front
    public String dequeue() {
        front = (front + 1) % capacity;
        count--;
        return arr[front];
    }
    //Returns the front of the queue 
    public String peek() {
        return arr[front];
    }
    //Testing purposes 
    public static void main(String[] args) {
        Queue q = new Queue(3);

       

        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
    }

}
