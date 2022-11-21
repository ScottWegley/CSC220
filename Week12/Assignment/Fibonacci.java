package Week12.Assignment;

import java.io.Serializable;

public class Fibonacci extends FibonacciBase implements Serializable {
	
	public Fibonacci (int n) {
		fibs = new int[n][2];
	}
	
	@Override
	public int fibI(int N) throws IllegalArgumentException {
		if (N <= 0) {
			throw new IllegalArgumentException("invalid argument");
		}
		int f1 = 1;
		int f2 = 1;
		for (int i = 3; i <= N; ++i) {
			int f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f2;
	}

	@Override
	public int fibR(int N) throws IllegalArgumentException {
		if (N <= 0) {
			throw new IllegalArgumentException("invalid argument");
		}
		if (N == 1 || N == 2) {
			return 1;
		}
		else {
			return fibR(N-1) + fibR(N-2);
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < fibs.length; ++i) {
			s += fibs[i][0] + "\t" + fibs[i][1] + "\n";
		}
		return s;
	}

}