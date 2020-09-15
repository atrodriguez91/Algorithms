package main;
import java.util.EmptyStackException;

public class Pop {
    Node runPop(){
    if (Stack.isEmpty()) {
        throw new EmptyStackException();
    } else {
        Node retValue = Stack.top;
        Stack.top = Stack.top.next;
        return retValue;
    }
}
    
}

