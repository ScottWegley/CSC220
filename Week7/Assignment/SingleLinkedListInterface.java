package Week7.Assignment;

// import java.util.Iterator;

public interface SingleLinkedListInterface<T> {

    // -- returns true if list is empty
    boolean isEmpty();

    // -- returns the number of objects in the list
    int size();

    // -- returns true if list contains object o, false otherwise
    // compare just the value of the object within the Node, not its reference nor
    // the previous and next links in the linked list
    boolean contains(T o);

    // -- convert the list to an array T of length size
    // make sure to unwrap the objects from their Nodes
    // use the makearray(c) method in the abstract class to construct the array
    T[] toArray();

    // -- insert an object e at front of list
    // will have to wrap with an object of type Node<T> for a linked list
    void add(T e);

    // -- insert an object e at position
    // if index > size then add to back
    // if index < 0 throw exception
    // will have to wrap with an object of type Node<T> for a linked list
    void add(int index, T element) throws IndexOutOfBoundsException;

    // -- remove first occurrence of an object T
    // compare the value of the object within the Node, not its reference nor
    // the previous and next links in the linked list
    // return true if object is found/removed, false otherwise
    boolean remove(T o);

    // -- remove object at position index
    // return the removed object
    T remove(int index) throws IndexOutOfBoundsException;

    // -- remove all objects from list
    void clear();

    // -- returns object at position index
    T get(int index) throws IndexOutOfBoundsException;

    // -- replace object at specified position index with given object e
    // returns the original object at the specified index of the list
    T set(int index, T e) throws IndexOutOfBoundsException;

    // -- return the index of the first occurrence of object e, -1 if not in list
    // compare the value of the object within the Node, not its reference nor
    // the previous and next links in the linked list
    int indexOf(T e);

    // -- return the index of the last occurrence of object o, -1 if not in list
    // only compare the value of the object within the Node, not the links
    // reference nor the previous and next links in the linked list
    int lastIndexOf(T o);

    // -- unused at this time
    // Iterator<T> iterator ();

}