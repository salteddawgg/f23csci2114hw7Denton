public final class denton_7 {

    public static void main(String[] args) {
        System.out.println(new denton_7().run());
    }

    public String run() {
        int limit = 150000; 
        boolean[] sieve = sieveOfEratosthenes(limit);
        int count = 0;
        
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                count++;
                if (count == 10001) {
                    return Integer.toString(i);
                }
            }
        }
        return "prim to small my boi ha ha your p is to small";  // If the sieve limit was too small
    }

    private static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] sieve = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }
}
