package Week5.Week5Assignment.MySolution;

public class LinkedStack<E> {
    public Node<E> top, bottom;
    private int currentSize;
    
    public LinkedStack() {
        top = null;
        bottom = null;
        currentSize = 0;
    }
}
