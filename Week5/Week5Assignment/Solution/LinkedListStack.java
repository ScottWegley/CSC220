package Week5.Week5Assignment.Solution;

public class LinkedListStack {
    private Node head; // the first node

    // nest class to define linkedlist node
    private class Node {
        int value;
        Node next;
    }

    public LinkedListStack() {
        head = null;
    }

    // Remove value from the beginning of the list for demonstrating behaviour of
    // stack
    public int pop() throws LinkedListEmptyException {
        if (head == null) {
            throw new LinkedListEmptyException();
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    // Add value to the beginning of the list for demonstrating behaviour of stack
    public void push(int value) {
        Node oldHead = head;
        head = new Node();
        head.value = value;
        head.next = oldHead;
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        LinkedListStack linkedstack = new LinkedListStack();
        try {
            linkedstack.push(20);
            linkedstack.push(50);
            linkedstack.push(80);
            linkedstack.push(40);
            linkedstack.push(60);
            linkedstack.push(75);
            System.out.println("Element removed from LinkedList: " + linkedstack.pop());
            System.out.println("Element removed from LinkedList: " + linkedstack.pop());
            linkedstack.push(10);
            System.out.println("Element removed from LinkedList: " + linkedstack.pop());
            printList(linkedstack.head);
        } catch (LinkedListEmptyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
}
