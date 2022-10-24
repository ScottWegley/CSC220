package Week9.Assignment;

public interface PrimeNumberInterface {

	// -- returns an array of prime factors of p
	long[] primeFactors(long p);

	// -- returns true if p is prime, false otherwise
	boolean isPrime(long p);

	// -- returns the smallest prime number larger than p
	//    p can be prime or composite.
	long nextPrime(long p);

}