package Week5.Week5Assignment.MySolution;

public class LinkedQueue<E> {

    public Node<E> front, rear;
    private int currentSize;

    public LinkedQueue() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public boolean empty() {
        return (currentSize == 0);
    }

    public void push(E data) {
        Node<E> myNode = new Node<E>(data);
        myNode.priority = currentSize + 1;
        if (empty()) {
            rear = myNode;
            front = rear;
        } else {
            Node<E> prev = rear;
            rear = myNode;
            prev.next = rear;
        }
        currentSize++;
        updatePriority();
        System.out.println("Pushed: " + myNode);
    }

    public void push(E data, int priority) {
        Node<E> myNode = new Node<E>(data);
        myNode.priority = priority;
        if (empty()) {
            rear = myNode;
            front = rear;
        } else {
            myNode.next = front;
            front = myNode;

        }
        if (priority > 1) {
            Node<E> temp = front.next;
            front.next = front.next.next;
            temp.next = front;
            front = temp;
            bumpPriority();
        }
        currentSize++;
        updatePriority();
        System.out.println("Pushed: " + myNode);
    }

    public Node<E> pop() {
        if (empty())
            return null;
        Node<E> out = front;
        front = front.next;
        currentSize--;
        updatePriority();
        System.out.println("Popped: " + out.element);
        return out;
    }

    public Node<E> peek() {
        System.out.println("Peeked: " + front.element);
        return front;
    }

    public int size() {
        return currentSize;
    }

    public void updatePriority() {
        if (empty())
            return;
        Node<E> active = front;
        for (int i = 1; i <= currentSize; i++) {
            active.priority = i;
            active = active.next;
        }
    }

    public void bumpPriority() {
        Node<E> prev = front;
        Node<E> active = front.next;
        Node<E> tail = active.next;
        while (active.next != null) {
            if (active.priority > tail.priority) {
                active.next = tail.next;
                tail.next = active;
                prev.next = tail;
                prev = tail;
                tail = active.next;
            } else {
                prev = prev.next;
                active = active.next;
                tail = tail.next;
            }
        }
    }

    public void display() {
        if (empty()) {
            System.out.println("This queue is empty");
            return;
        }
        System.out.println("Your Queue is Below");
        Node<E> toRead = front;
        while (toRead != null) {
            System.out.println(toRead.element + " " + Integer.toString(toRead.priority));
            toRead = toRead.next;
        }
    }

}
