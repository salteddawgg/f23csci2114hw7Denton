public final class denton_12 {

    public static void main(String[] args) {
        System.out.println(new denton_12().run());
    }

    public String run() {
        int triangle = 0;
        for (int i = 1; ; i++) {
            if (Integer.MAX_VALUE - triangle < i) {
                throw new ArithmeticException("Overflow");
            }
            triangle += i;  // Calculate the tri num
            if (countDivisors(triangle) > 500) {
                return Integer.toString(triangle);
            }
        }
    }

    // Returns the number of divisors of n
    private static int countDivisors(int n) {
        int count = 0;
        int end = sqrt(n);
        for (int i = 1; i <= end; i++) { // Correct loop condition to include end
            if (n % i == 0) {
                count += 2; // i and n/i are divisors
            }
        }
        if (end * end == n) { // If n is a perfect square
            count--;
        }
        return count;
    }

    // Calculates the integer square root of n
    private static int sqrt(int n) {
        return (int) Math.sqrt(n);
    }
}
