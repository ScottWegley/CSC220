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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getNextPerfect(long p) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
