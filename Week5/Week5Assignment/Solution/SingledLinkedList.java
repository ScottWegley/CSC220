/* package Week5.Week5Assignment.Solution;

package LinkedList;

public class SingleLinkedList<T> extends SingleLinkedListAbstract<T> implements SingleLinkedListInterface<T> {

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(T o) {
		LinkedListNode<T> ptr = this.head;
		for (int i = 0; i < size; ++i) {
			// -- must wrap the object o in an LLNode to make sure the .equals works properly
			if (ptr.equals(new LinkedListNode<T>(o))) {
				return true;
			}
			ptr = ptr.getNext();
		}
		return false;
	}

	@Override
	public T[] toArray() {
		
		T array[] = this.makearray(size);
		
		LinkedListNode<T> ptr = this.head;
		for (int i = 0; i < size; ++i) {
			// -- extract the object from the LLNode wrapper
			array[i] = ptr.getValue();
			ptr = ptr.getNext();
		}
		return array;
	}

	@Override
	// -- default is to add to front of list
	public void add(T e) {
		this.add(0, e);		
	}

	// -- returns reference to the (loc-1)'th node in the list
	private LinkedListNode<T> findLoc(int loc)
	{
		LinkedListNode<T> ptr = head;
		int i = 0;
		while ((i < loc - 1) && (ptr != null)) {
			++i;
			ptr = ptr.getNext();
		}
		return ptr;		
	}
	
	
	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException {
		
		if (index < 0) {
			throw new IndexOutOfBoundsException("invalid index");
		}
		
		// -- wrap the element in an LLNode
		LinkedListNode<T> node = new LinkedListNode<T>(element);
		
		// -- if list is empty, add to front
		if (size == 0) {
			node.setNext(tail);
			head = node;
			tail = node;
		}
		// -- if position is 0, add to front
		else if (index == 0) {
			node.setNext(head);
			head = node;			
		}
		// -- else add to the interior or end of list
		else {
			// -- find the node at the given index
			LinkedListNode<T> ptr = this.findLoc(index);
			// -- if index > size add to end
			if (ptr == null) { // index > size
				node.setNext(null);
				tail.setNext(node);
				tail = node;	
			}
			// -- if in the interior, add at location (before found node)
			else {
				node.setNext(ptr.getNext());
				ptr.setNext(node);	
			}
		}
		++size;
	}

	@Override
	public boolean remove(T o) {
		LinkedListNode<T> node = this.findLoc(new LinkedListNode<T>(o));
		// -- nothing to remove
		if ((size == 0) || (node == null)) {
			return false;
		}
		// -- remove the front
		else if (head == node) {
			head = head.getNext();
			return true;
		}
		// -- remove the back
		else if (tail == node) {
			// -- find the node before the back
			LinkedListNode<T> beforeTail = head;
			while (beforeTail.getNext() != tail) {
				beforeTail = beforeTail.getNext();
			}
			beforeTail.setNext(null);
			tail = beforeTail;
			return true;
		}
		else {
			// -- find the node before the node
			LinkedListNode<T> beforeNode = head;
			while (beforeNode.getNext() != node) {
				beforeNode = beforeNode.getNext();
			}
			beforeNode.setNext(node.getNext());
			return true;
		}
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("remove: bad index");
		}
		
		LinkedListNode<T> node = this.findLoc(index + 1);
		// -- nothing to remove
		if ((size == 0) || (node == null)) {
			return null;
		}
		// -- remove the front
		else if (head == node) {
			head = head.getNext();
			return node.getValue();
		}
		// -- remove the back
		else if (tail == node) {
			// -- find the node before the back
			LinkedListNode<T> beforeTail = head;
			while (beforeTail.getNext() != tail) {
				beforeTail = beforeTail.getNext();
			}
			beforeTail.setNext(null);
			tail = beforeTail;
			return node.getValue();
		}
		else {
			// -- find the node before the node
			LinkedListNode<T> beforeNode = head;
			while (beforeNode.getNext() != node) {
				beforeNode = beforeNode.getNext();
			}
			beforeNode.setNext(node.getNext());

			return node.getValue();
		}
	}

	@Override
	public void clear() {
		// -- set head and tail to null and let the
		//    Garbage Collector clean up the mess
		head = tail = null;	
		size = 0;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("remove: bad index");
		}
		
		LinkedListNode<T> node = this.findLoc(index + 1);

		// -- extract the object from the wrapper LLNode and return it
		return node.getValue();
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("set: bad index");
		}
		T r = remove(index);
		add(index, element);
		return r;
	}

	@Override
	public int indexOf(T o) {
		return findIndexForward(new LinkedListNode<T>(o));
	}

	@Override
	public int lastIndexOf(T o) {
		return findIndexReverse(new LinkedListNode<T>(o));
	}

	// -- returns reference to the first occurrence of the object if it is in the list
	private LinkedListNode<T> findLoc(LinkedListNode<T> e)
	{
		LinkedListNode<T> ptr = this.head;
		for (int i = 0; i < size; ++i) {
			if (ptr.equals(e)) {
				return ptr;
			}
			ptr = ptr.getNext();
		}
		return null;
	}

	// -- returns the index of the first occurrence of the object if it is in the list
	private int findIndexForward(LinkedListNode<T> e)
	{
		LinkedListNode<T> ptr = this.head;
		for (int i = 0; i < size; ++i) {
			if (ptr.equals(e)) {
				return i;
			}
			ptr = ptr.getNext();
		}
		return -1;
	}
	
	// -- returns the index of the last occurrence of the object if it is in the list
	private int findIndexReverse(LinkedListNode<T> e)
	{
		int index = -1;
		LinkedListNode<T> ptr = this.head;
		for (int i = 0; i < size; ++i) {
			if (ptr.equals(e)) {
				index = i;
			}
			ptr = ptr.getNext();
		}
		return index;
	}
	
	
	// -- not in the interface, just added because it's interesting
	public void reverse () {
		SingleLinkedList<T> rlist = new SingleLinkedList<T>();
		LinkedListNode<T> ptr = this.head;
		while (ptr != null) {
			rlist.add(ptr.getValue());
			ptr = ptr.getNext();
		}		
		this.head = rlist.head;
		this.tail = rlist.tail;
	}

} */