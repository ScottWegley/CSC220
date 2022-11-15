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
        PrimePerfectGUI.setCalc(true);
        for (int i = remaining; i > 0;) {
            _p++;
            if(_p % 1000000 == 0){
                System.out.println(_p);
            }
            if(PerfectNumber.isPerfectSt(_p)){
                i--;
                PrimePerfectGUI.addToList(_p);
            }
        }
        PrimePerfectGUI.setCalc(false);
        super.run();
    }

    @Override
    public void interrupt() {
        reset();
        super.interrupt();
    }

    public void reset() {
        _p = 0;
        remaining = 0;
    }
}