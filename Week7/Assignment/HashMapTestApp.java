package Week7.Assignment;

import java.io.FileWriter;
import java.io.IOException;

public class HashMapTestApp {

	public static void main(String[] args) {
		// -- construct a HashMap that uses a String as
		//    the key and Double as the data type
		HashMap<String, Double> hmsd = new HashMap<String, Double>(37);

		// -- insert some values into the HashMap
		for (int i = 0; i < 1000; ++i) {
			hmsd.add(i + "", (double)i);
		}
		
		System.out.println(hmsd);


		try {
			FileWriter csvwriter = new FileWriter("hashmap.csv");
			int s[] = hmsd.getSizes();
			for (int i : s) {
				csvwriter.write(i + "\n");
			}
			csvwriter.close();
		} catch (IOException e) {			
			System.out.println(e);
		}	
		
		HashMap<Double, Integer> hmdi = new HashMap<Double, Integer>(17);
		// -- insert some values into the HashMap
		for (int i = 0; i < 17; ++i) {
			hmdi.add(i * 2.1, i);
		}
		System.out.println(hmdi);
		
	}
}