package Algorithms.src;

public class Push {
    public NodeLists top;
    

    void push() {
        NodeLists n = new NodeLists();
        n.item = "A";
        NodeLists oldTop = this.top;
        n.next = oldTop;
        this.top = n;
        
    }
}
