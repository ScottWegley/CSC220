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
        return p != 1L;
    }

    static boolean isPrimeSt(long p) {
        for (long i = 2L; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return p != 1L;
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

class PrimeThread extends Thread {
    private static long _p;

    public static void setP(long p) {
        _p = p;
    }

    @Override
    public void run() {
        PrimePerfectGUI.setCalcPrime(true);
        ArrayList<Long> factors = new ArrayList<Long>();
        for (long i = 2L; i <= (_p); i++) {
            if (_p % i == 0) {
                if (PrimeNumber.isPrimeSt(i)) {
                    factors.add(i);
                    _p = _p / i;
                }
            }
        }
        long[] arr = new long[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            arr[i] = factors.get(i);
        }
        reset();
        PrimePerfectGUI.addFactor(arr);
        PrimePerfectGUI.setCalcPrime(false);
        super.run();
    }

    @Override
    public void interrupt() {
        reset();
        super.interrupt();
    }

    public void reset() {
        _p = 0;
    }
}