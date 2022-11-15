package Week9.Assignment;

public class PerfectNumber implements PerfectNumberInterface {

    long _p;

    public void main(long p) {
        _p = p;
        MyThread mt = new MyThread();
    }

    @Override
    public boolean isPerfect(long n) {
        long sum = 1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        return sum == n && sum != 1L;
    }

    public static boolean isPerfectSt(long n) {
        long sum = 1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        return sum == n && sum != 1L;
    }

    @Override
    public long getPerfect(long p) {
        return (long) (Math.pow(2, p - 1) * (Math.pow(2, p) - 1));
    }

    @Override
    public long getNextPerfect(long p) throws InterruptedException {
        p++;
        while(!isPerfect(p)){
            p++;
        }
        return p;
    }

}

class MyThread extends Thread {
    public static long _p;
    public static int remaining = 0;

    public static void setP(long p) {
        System.out.println("setting to " + p);
        _p = p;
    }

    public static void setR(int r){
        remaining = r;
    }

    public static long getP() {
        return _p;
    }

    @Override
    public void run() {
        _p += 1;
        while (!PerfectNumber.isPerfectSt(_p)) {
            _p++;
        }
        super.run();
    }
}