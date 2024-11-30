
//Euler problem No.4, answer: 906609
public class denton_4 {

    public static void main(String[] args) {
        int maxPalindrome = 0;

        for (int A = 999; A >= 100; A--) {
            for (int B = 999; B >= 100; B--) {
                int product = A * B;

                if (product >= 100001 && product <= 998011) {
                    if (isPalindrome(product) && product > maxPalindrome) {
                        maxPalindrome = product;
                    }
                }
            }
        }

        System.out.println(maxPalindrome);
    }

    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }
}
