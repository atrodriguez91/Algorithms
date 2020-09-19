package main;

import java.util.List;

public class SelfStack<S>  {
    //Stacking class with members 
    SelfStack<S> previous;
    String value;
    // Stacking method
    SelfStack() {
        
    }
    //Adding a value into the stack
    SelfStack(S value) {
        this.value = (String) value;
    }
    //Method to move value
    SelfStack(SelfStack<S> previous, S value) {
        this.previous = previous;
        this.value = (String) value;
    }

    //Pushing a new node onto the stack
    public void push(List<String> newList) {
        this.previous = new SelfStack<S>(this.previous, (S) this.value);
        this.value = newList.toString();

    }

    //Removing a node if the stack isn't empty
    //Return the top of the stack after
    public S pop() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        S top = (S) this.value;
        this.value = this.previous.value;
        this.previous = this.previous.previous;

        return top;
    }

   //See top without removing
    public S peek() {
        return (S) this.value;
    }

   //Checking stack if null
    public boolean isEmpty() {
        return this.previous == null;
    }

    //Returns size of the stack (for testing)
    public int size() {
        return this.isEmpty() ? 0: 1 + this.previous.size();
    }

    //Search for an individual stack
    public int search(Object o) {
        int count = 1;

        for (SelfStack<S> stack = this; !stack.isEmpty(); stack = stack.previous) {
            if(stack.value.equals(o))
                return count;
            count ++;
        }   
        return -1;
    }

	//Testing the class only
    public static void main(String[] args) {
        SelfStack<Integer> selfStack = new SelfStack<Integer>();

        System.out.println(selfStack.isEmpty());

        System.out.println(selfStack.size());

        System.out.println(selfStack.peek());

        selfStack.pop();

        

    }
}
