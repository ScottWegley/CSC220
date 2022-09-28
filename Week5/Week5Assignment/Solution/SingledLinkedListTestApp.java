/* package Week5.Week5Assignment.Solution;
package LinkedList;


public class SingleLinkedListTestApp {

	public static void main(String[] args) {
		
		// -- construct a linked-list of Integer and add some items
		//    print it forward and backward
		//    note that auto-boxing will convert int to Integer
		SingleLinkedList<Integer> dlli = new SingleLinkedList<Integer>();
		
		System.out.println("Test isEmpty(), add(x, y) to front, toString()");
		System.out.println(dlli.isEmpty());
		dlli.add(0, 1);
		dlli.add(0, 2);
		dlli.add(0, 3);
		System.out.println(dlli.isEmpty());
		System.out.println(dlli);

		
		// -- add an item to the back
		System.out.println("Test add(x, y) to back");
		dlli.add(44, 4);
		System.out.println(dlli);

		// -- add some items in the middle
		System.out.println("Test add(x, y) to interior");
		dlli.add(2, 5);
		dlli.add(3, 6);
		System.out.println(dlli);
		
		// -- convert to an Integer[] and print forward
		System.out.println("Test toArray()");
		Object ai[];
		ai = dlli.toArray();
		int index = 0;
		for (Object i : ai) {
			System.out.print("ai[" + index++ + "]=" + i + "; ");
		}
		System.out.println();
		
		// -- check for containment 
		//    auto-boxing will convert int 4 and int 44 to Integers
		System.out.println("Test contains()");
		System.out.println(dlli.contains(4));
		System.out.println(dlli.contains(44));
		System.out.println();
		
		// -- clear all elements from the linked-list and check if it is empty
		System.out.println("Test clear()");
		dlli.clear();
		System.out.println(dlli.isEmpty());
		
		// -- construct a linked-list of Integer and print it forward
		System.out.println("Create a new list of Integer");
		dlli = new SingleLinkedList<Integer>();
		dlli.add(0, 4);
		dlli.add(0, 3);
		dlli.add(0, 2);
		dlli.add(0, 1);
		System.out.println(dlli);
		
		// -- remove some values
		//    auto-boxing will not work in this instance because there
		//    is a method remove(int)
		System.out.println("Test remove()");
		dlli.remove(new Integer(2));
		System.out.println(dlli);

		dlli.remove(new Integer(1));
		System.out.println(dlli);

		dlli.remove(new Integer(4));
		System.out.println(dlli);
		
		dlli.remove(new Integer(3));
		System.out.println(dlli);
	
		// -- construct a linked-list of Integer
		System.out.println("Create a new list of Integer");
		dlli = new SingleLinkedList<Integer>();
		dlli.add(0, 4);
		dlli.add(0, 3);
		dlli.add(0, 2);
		dlli.add(0, 1);
		System.out.println(dlli);

		// -- remove some objects at specific indices
		//    argument will not be auto-boxed since remove(int) exists
		System.out.println("Test remove(x)");
		System.out.println("removed " + dlli.remove(3) + " from location " + 3);
		System.out.println(dlli);

		// -- construct a linked-list of Double
		System.out.println("Create a new list of Double");
		SingleLinkedList<Double> dlld = new SingleLinkedList<Double>();
		dlld.add(0, 4.4);
		dlld.add(0, 3.3);
		dlld.add(0, 2.2);
		dlld.add(0, 1.1);
		dlld.add(0, 3.3);
		System.out.println(dlld);
		
		// -- search the list from the front and back
		System.out.println("Test indexOf(x) and lastIndexOf(x)");
		System.out.println(dlld.indexOf(3.3));
		System.out.println(dlld.lastIndexOf(3.3));
		
		// -- replace the object at location 2
		System.out.println("test set(x, y)");
		Double d = dlld.set(2,  5.5);
		System.out.println("replaced: " + d + " with " + new Double(5.5));
		System.out.println(dlld);
		
		// -- try to replace the object at location 100
		//    note that there is no object at location 100
		System.out.println("Test set(x, y) out of bounds");
		try {
			dlli.set(100,  100);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println();

		// -- construct a link-list of String
		System.out.println("Create a new list of String");
		SingleLinkedList<String> dlls = new SingleLinkedList<String>();
		dlls.add("World!");
		dlls.add(", ");
		dlls.add("Hello");

		System.out.println(dlls);


	}

} */