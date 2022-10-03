package Week5.Week5Assignment;

public class LinkedStack<E> {
    public Node<E> top, bottom;
    private int currentSize;
    
    public LinkedStack() {
        top = null;
        bottom = null;
        currentSize = 0;
    }

    public void push(E data){
        Node<E> myNode = new Node<E>(data);
        if(empty(false)){
            top = myNode;
            bottom = top;
        } else {
            myNode.next = top;
            top = myNode;
        }

        System.out.println("Pushed: " + myNode);
        currentSize++;
    }

    public Node<E> pop(){
        if(empty(false)) return null;
        Node<E> out = top;
        top = top.next;
        System.out.println("Popped: " + out);
        currentSize--;
        return out;
    }

    public Node<E> peek(){
        System.out.println("Peeked: " + top);
        return top;
    }

    public void display(){
        if(empty(false)) return;
        Node<E> active = top;
        System.out.println("You Stack is Below");
        while(active != null){
            System.out.println(active);
            active = active.next;
        }
    }

    public boolean empty(boolean log){
        if(log) System.out.println((currentSize == 0));
        return (currentSize == 0);
    }

    public int count(){
        System.out.println("There are currently " + currentSize + " nodes in the stack");
        return currentSize;
    }
}
