package Algorithms.src;

public class Node {

    String item;
    Node next;

    Node(String item) {
        this.item = item;
        this.next = null;
    }
    


public Node head = null;
public Node tail = null;

public void addPoint(String item) {
    Node newPoint = new Node(item);
}
}