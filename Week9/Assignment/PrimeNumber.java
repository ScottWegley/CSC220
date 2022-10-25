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
    }

    @Override
    public boolean isPrime(long p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public long nextPrime(long p) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
