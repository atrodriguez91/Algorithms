package main;

public class LinkedList {
    //Creation of Node class with members
    class Node {
        String item;
        Node next;

        //Constructor for node 
        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }
    

    //Init head and tall with Node pointing to null for init
    public Node head = null;
    public Node tail = null;
    //Method for adding Nodes into a Linked List
    public void addPoint(String item) {
        Node newPoint = new Node(item);

        if(head == null) {
            head = newPoint;
            tail = newPoint;
        } else {
            tail.next = newPoint;
            tail = newPoint;
        }
    }
    //Method to display, not required, for testing purposes 
    public void display() {
        Node current = head;
        //Simple print if empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Current list: ");

        while(current !=  null) {
            System.out.println(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

}