package Algorithms.src;

public class Push {
    public Node top;
    

    void push() {
        Node n = new Node();
        n.item = "A";
        Node oldTop = this.top;
        n.next = oldTop;
        this.top = n;
        
    }
}
