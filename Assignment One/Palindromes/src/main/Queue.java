package main;

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

    public void enqueue(String item) {
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        
    }

    public void dequeue() {
        front = (front + 1) % capacity;
        count--;
    }

    public String peek() {
        return arr[front];
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");

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
