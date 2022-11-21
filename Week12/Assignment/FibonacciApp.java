package Week12.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FibonacciApp {

	public static void main(String[] args) {

		int n = 15;
    	
		FibonacciBase fib = new Fibonacci(n);
		fib.getFibs(n);
		System.out.println(fib);
		File fibfile = new File("Fibonnaci.ser");
		try {
			
			// -- wrap the target disc file in a raw byte FileOutputStream (object inside file)			
			//    and an ObjectOutputStream for serialization
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fibfile));
			
			// -- write the array of objects to the file
			out.writeObject(fib);
			
			// -- close the stream
			out.close();
			
			
			System.out.println("Serialized data is saved in " + fibfile.getAbsolutePath());
			
		} catch (IOException i) {
			// -- in case the file cannot be opened
			System.out.println("can't open file");
		}

		System.out.println("Serialized data being read from " + fibfile.getAbsolutePath());
		// -- create a reference to an array of Rectangle
		try {
			FibonacciBase f = null;

			// -- wrap the target disc file in a FileInputStream (object inside file)
			//    and an ObjectInputStream
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fibfile));
			// -- read the object from the file
			//    note that this returns an Object and therefore must be cast
			//    to the appropriate type to ensure usability
			Object ob = in.readObject();
			
			// -- close the stream
			in.close();

			// -- verify the object class and cast
			if (ob instanceof Fibonacci) {
				f = (FibonacciBase)ob;
			}
			System.out.println(f);
		} catch (IOException i) {
			// -- in case the file cannot be opened
			System.out.println("can't open file");
			return;
		} catch (ClassNotFoundException c) {
			// -- in case the Rectangle.class file cannot be found after 
			//    reading the file
			System.out.println("Rectangle class not found");
			return;
		}
		
	}

}
