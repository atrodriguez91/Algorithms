package Algorithms.src;

public class NodeLists {

    String item;
    NodeLists next;

    NodeLists(String item) {
        this.item = item;
        this.next = null;
    }
    


public NodeLists head = null;
public NodeLists tail = null;

public void addPoint(String item) {
    NodeLists newPoint = new NodeLists(item);

    if(head == null) {
        head = newPoint;
        tail = newPoint;
    } else {
        tail.next = newPoint;
        tail = newPoint;
    }
}

public void display() {
    NodeLists current = head;

    if(head == null) {
        System.out.println("List is empty");
        return;
    }

    System.out.println("Current list: ");

    while(current !=  null) {
        System.out.printlin(current.item + " ");
        current = current.next;
    }
    System.out.println();
}


}