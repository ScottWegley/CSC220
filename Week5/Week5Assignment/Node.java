package Week5.Week5Assignment;

public class Node<E> {

    E element;
    Node<E> next;
    int priority;

    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    public Node() {
        this.element = null;
        this.next = null;
    }

    public void tag(Node<E> inNext){
        this.next = inNext;
    }

    @Override
    public String toString() {
        return element + " " + Integer.toString(priority);
    }
    
}
