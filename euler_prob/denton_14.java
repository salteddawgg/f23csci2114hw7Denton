import java.math.BigInteger;

public final class denton_14 {

    public static void main(String[] args) {
        System.out.println(new denton_14().run());
    }

    // Limit of numb
    private static final int LIMIT = 1_000_000;

    // Memoization array to store chain lengths for small int
    private static final int[] collatzCache = new int[LIMIT];

    public String run() {
        int maxArg = 1; // Starting number with the longest chain
        int maxChain = 1; // Length of the longest chain. big ol boi

        for (int i = 1; i < LIMIT; i++) {
            int chainLen = collatzChainLength(i);
            if (chainLen > maxChain) {
                maxArg = i;
                maxChain = chainLen;
            }
        }
        return Integer.toString(maxArg);
    }

    // Returns the chain length of the given int
    private int collatzChainLength(long n) {
        if (n < LIMIT && collatzCache[(int) n] != 0) {
            return collatzCache[(int) n];
        }

        int length;
        if (n == 1) {
            length = 1; // Base case
        } else if ((n & 1) == 0) { // n is even
            length = 1 + collatzChainLength(n / 2);
        } else { // n is odd
            length = 1 + collatzChainLength(3 * n + 1);
        }

        // Store in cache if within limit
        if (n < LIMIT) {
            collatzCache[(int) n] = length;
        }

        return length;
    }
}
