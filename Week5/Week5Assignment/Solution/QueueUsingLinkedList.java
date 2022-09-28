/* public class QueueUsingLinkedList {
    private Node front, rear;
    private int currentSize; // number of items

    // class to define linked node
    private class Node {
        int data;
        Node next;
    }

    // Zero argument constructor
    public QueueUsingLinkedList() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Remove item from the beginning of the list.
    public int popqueue() {
        int data = front.data;
        front = front.next;
        if (isEmpty()) {
            rear = null;
        }
        currentSize--;
        System.out.println(data + " removed from the queue");
        return data;
    }

    // Add data to the end of the list.
    public void pushqueue(int data) {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty()) {
            front = rear;
        } else {
            oldRear.next = rear;
        }
        currentSize++;
        System.out.println(data + " added to the queue");
    }

    public static void main(String a[]) {

        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.pushqueue(6);
        queue.popqueue();
        queue.pushqueue(3);
        queue.pushqueue(99);
        queue.pushqueue(56);
        queue.popqueue();
        queue.pushqueue(43);
        queue.popqueue();
        queue.pushqueue(89);
        queue.pushqueue(77);
        queue.popqueue();
        queue.pushqueue(32);
        queue.pushqueue(232);
    }
} */