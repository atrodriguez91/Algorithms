package main;

interface FullStack<S> {
    void push(S value);
    S pop();
    S peek();
    boolean isEmpty();
    int size();
    int search(Object o);
}
