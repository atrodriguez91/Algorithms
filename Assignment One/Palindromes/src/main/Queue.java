package main;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    String[] arr;
    int front;
    int rear;
    int capacity;
    int count;

    Queue(int size) {
        arr = new String[size];
        front = 0;
        rear = -1;
        count = 0;
        capacity = size;
    }

    public void enqueue(ArrayList<String> newList) {
        rear = (rear + 1) % capacity;
        arr[rear] = newList.toString();
        count++;
        
    }

    public String dequeue() {
        front = (front + 1) % capacity;
        count--;
        return arr[front];
    }

    public String peek() {
        return arr[front];
    }

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
