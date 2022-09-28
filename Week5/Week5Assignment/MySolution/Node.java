package Week5.Week5Assignment.MySolution;

public class Node<E> {

    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }

    public void tag(Node<E> inNext){
        this.next = inNext;
    }
    
}
