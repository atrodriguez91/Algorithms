package main;


public class SelfStack<S>  {

    SelfStack<S> previous;
    S value;

    SelfStack() {
        
    }

    SelfStack(S value) {
        this.value = value;
    }

    SelfStack(SelfStack<S> previous, S value) {
        this.previous = previous;
        this.value = value;
    }

    
    public void push(S value) {
        this.previous = new SelfStack<S>(this.previous, this.value);
        this.value = value;

    }

    
    public S pop() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        S top = this.value;
        this.value = this.previous.value;
        this.previous = this.previous.previous;

        return top;
    }

   
    public S peek() {
        return this.value;
    }

   
    public boolean isEmpty() {
        return this.previous == null;
    }

    
    public int size() {
        return this.isEmpty() ? 0: 1 + this.previous.size();
    }

    
    public int search(Object o) {
        int count = 1;

        for (SelfStack<S> stack = this; !stack.isEmpty(); stack = stack.previous) {
            if(stack.value.equals(o))
                return count;
            count ++;
        }   
        return -1;
    }

	
    public static void main(String[] args) {
        SelfStack<Integer> selfStack = new SelfStack<Integer>();

        System.out.println(selfStack.isEmpty());

        selfStack.push(2);
        selfStack.push(5);
        selfStack.push(7);
        selfStack.push(16);

        System.out.println(selfStack.size());

        System.out.println(selfStack.peek());

        selfStack.pop();

        

    }
}
