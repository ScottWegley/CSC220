package Week9.Assignment;

public interface PerfectNumberInterface {

    // -- return true if n is perfect, false otherwise
    // implements the "guess and verify" technique where
    // n is the "guess"
    public boolean isPerfect(long n);

    // -- return a perfect number using the formula perfect(p)
    public long getPerfect(long p);

    // returns the smallest perfect number larger than p
    public long getNextPerfect(long p) throws InterruptedException;

}