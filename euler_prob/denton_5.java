
//Euler problem No.7, answer: 104743
public class denton_5 {
    public static void main(String[] args) {
        int limit = 200000;
        boolean[] isPrime = new boolean[limit];

        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int primeCount = 0;
        int prime = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                primeCount++;
                if (primeCount == 10001) {
                    prime = i;
                    break;
                }
            }
        }

        System.out.println(prime);
    }
}
