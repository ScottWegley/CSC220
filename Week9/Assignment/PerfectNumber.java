package Week9.Assignment;

public class PerfectNumber implements PerfectNumberInterface {

    @Override
    public boolean isPerfect(long n) {
        long sum = 1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        return sum == n;
    }

    @Override
    public long getPerfect(long p) {
        return (long) (Math.pow(2, p - 1) * Math.pow(2, p) - 1);
    }

    @Override
    public long getNextPerfect(long p) {
        p += 1;
        while (!isPerfect(p)) {
            p += 1;
        }
        return p;
    }

}
