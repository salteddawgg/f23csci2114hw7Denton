import java.math.BigInteger;

public final class denton_15 {

    public static void main(String[] args) {
        System.out.println(new denton_15().run());
    }

    
    private static final int GRID_SIZE = 20;

    public String run() {
        return binomialCoefficient(2 * GRID_SIZE, GRID_SIZE).toString();
    }

    // Computes the binomial coefficient "n choose k" = n! / (k! * (n - k)!)
    private static BigInteger binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return BigInteger.ZERO;
        }

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        // Compute the product n * (n-1) * ... * (n-k+1) / k!
        for (int i = 1; i <= k; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i + 1));
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        return numerator.divide(denominator);
    }
}
