package Week9.Assignment;

import java.util.ArrayList;

public class PrimeNumber implements PrimeNumberInterface {

    @Override
    public long[] primeFactors(long p) {
        ArrayList<Long> factors = new ArrayList<Long>();
        for (long i = 2L; i <= (p); i++) {
            if (p % i == 0) {
                if (isPrime(i)) {
                    factors.add(i);
                    p = p / i;
                }
            }
        }
        long[] arr = new long[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            arr[i] = factors.get(i);
        }
        return arr;
    }

    @Override
    public boolean isPrime(long p) {
        for (long i = 2L; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
    }

    static boolean isPrimeSt(long p) {
        for (long i = 2L; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
    }

    @Override
    public long nextPrime(long p) {
        p += 1;
        while (!isPrime(p)) {
            p += 1;
        }
        return p;
    }

}
