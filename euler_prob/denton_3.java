
//Euler problem No.3, answer: 6857
public class denton_3 {
    public static void main(String[] args) {
        long number = 600851475143L;
        long largestPrimeFactor = findLargestPrimeFactor(number);

        System.out.println("Largest prime factor of " + number + " is: " + largestPrimeFactor);
    }

    public static long findLargestPrimeFactor(long n) {
        long largestFactor = 1;

        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }

        if (n > 2) {
            largestFactor = n;
        }

        return largestFactor;
    }
}
