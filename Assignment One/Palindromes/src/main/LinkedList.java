package main;

public class LinkedList {
    class Node {
        String item;
        Node next;


        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }
    


    public Node head = null;
    public Node tail = null;

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

    public void display() {
        Node current = head;

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

    public static void main(String[] args) {
            
        LinkedList nList = new LinkedList();
        
        nList.addPoint("A");
        nList.addPoint("B");
        nList.addPoint("C");
        nList.addPoint("D");

        nList.display();

    }   
}