package main;

interface FullStack<S> {
    void push(S value);
    S pop();
    S peek();
    boolean isEmpty();
    int size();
    int search(Object o);
}

public class SelfStack<S> implements FullStack {

    SelfStack<S> previous;
    S value;

    SelfStack() {}

    SelfStack(S value) {
        this.value = value;
    }

    SelfStack(SelfStack<S> previous, S value) {
        this.previous = previous;
        this.value = value;
    }

    @Override
    public void push(Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int search(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
