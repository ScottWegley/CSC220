package Week7.Assignment;

public abstract class SingleLinkedListAbstract<T> {

    protected LinkedListNode<T> head = null;
    protected LinkedListNode<T> tail = null;

    protected int size; // -- number of items in list

    // -- use this method to create the array required by the
    // toArray() method
    protected T[] makearray(int c) {
        // -- Java does not allow instantiation of generic types,
        // must construct an Object and cast
        return (T[]) new Object[c];
    }

    @Override
    public String toString() {
        String s = "";
        LinkedListNode<T> ptr = this.head;
        while (ptr != null) {
            s = s + ptr + "->";
            ptr = ptr.getNext();
        }
        s = s + "null";
        return s;
    }

    // -- Inner class to define the node used by the linked-list
    protected class LinkedListNode<T> {

        // -- the object value
        private T value;

        // -- references to next and previous nodes
        // (e.g. for use in a linked list)
        private LinkedListNode<T> next;

        // -- parameter is assigned to value
        public LinkedListNode(T value) {
            this.value = value;
            this.next = null;
        }

        public void setNext(LinkedListNode<T> next) {
            this.next = next;
        }

        public LinkedListNode<T> getNext() {
            return this.next;
        }

        // -- returns the object stored at value
        // (e.g. removes the Node wrapper)
        public T getValue() {
            return this.value;
        }

        // -- uses toString of object stored at value
        @Override
        public String toString() {
            return "Node: " + value;
        }

        @Override
        public boolean equals(Object o) {
            LinkedListNode<T> e = (LinkedListNode<T>) o;
            T lhs = this.getValue();
            T rhs = e.getValue();

            return lhs.equals(rhs);
        }

    }

}