import java.util.ArrayList;
import java.util.List;

public final class denton_10 {

    private static final int LIMIT = 2000000;

    public static void main(String[] args) {
        System.out.println(new denton_10().run());
    }

    public String run() {
        long sum = 0;
        for (int p : listPrimes(LIMIT - 1)) {
            sum += p;
        }
        return Long.toString(sum);
    }

    // Sieve of Eratosthenes to find all primes <= n
    private static List<Integer> listPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
