package Week12.Assignment;

import java.io.Serializable;

public abstract class FibonacciBase implements Serializable {

    // -- holds computed Fibonacci numbers. This will be constructed
    // as a [n][2] array. Locations [i][0] hold values computed
    // with the iterative method. Locations [i][1] hold values
    // computed with the recursive method.
    protected int fibs[][];

    // -- Include a constructor that looks like this
    // public Fibonacci (int n) {
    // fibs = new int[n][2];
    // }

    // -- return the Nth Fibonacci number using an iterative algorithm
    public abstract int fibI(int N) throws IllegalArgumentException;

    // -- return the Nth Fibonacci number using a recursive algorithm
    public abstract int fibR(int N) throws IllegalArgumentException;

    // -- fills the fibs[][] array (see above) with the first N
    public void getFibs(int N) throws IllegalArgumentException {
        if (N < 0) {
            throw new IllegalArgumentException("invalid argument");
        }
        try {
            for (int i = 1; i <= N; ++i) {
                fibs[i - 1][0] = fibR(i);
                fibs[i - 1][1] = fibI(i);
            }
        } catch (IllegalArgumentException e) {
            throw e;
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
