package Week9.Assignment;

public class TestApp {
    public static void main(String[] args) {
        /* PerfectNumberInterface pf = new PerfectNumber();
        for (int p = 1; p < 20; ++p) {
            long perfect = pf.getPerfect(p);
            System.out.println("From main: " + p + " " + perfect + " " + pf.isPerfect(perfect));
        } */

        PrimeNumberInterface pr = new PrimeNumber();
        for (int i = 1; i < 20; ++i) {
            if (pr.isPrime(i)) {
                System.out.println(i + " is Prime");
            } else {
                long factors[] = pr.primeFactors(i);
                System.out.print(i + " = ");
                for (int f = 0; f < factors.length - 1; ++f) {
                    System.out.print(factors[f] + " * ");
                }
                System.out.println(factors[factors.length - 1]);
            }
        }
    }
}
