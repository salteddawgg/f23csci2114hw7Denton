public final class denton_17 {

    public static void main(String[] args) {
        System.out.println(new denton_17().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += toEnglish(i).length();
        }
        return Integer.toString(sum);
    }

    private static String toEnglish(int n) {
        if (n < 0 || n > 1000) {
            //i only added this because i thought it would be funny...and it was
            throw new IllegalArgumentException("womp womp i fucked up: " + n);
        }
            //this is all bs
        if (n == 1000) {
            return "onethousand";
        } else if (n >= 100) {
            return ONES[n / 100] + "hundred" + (n % 100 != 0 ? "and" + toEnglish(n % 100) : "");
        } else if (n >= 20) {
            return TENS[n / 10] + (n % 10 != 0 ? ONES[n % 10] : "");
        } else {
            return ONES[n];
        }
    }
    //took an embarising amount of time to figure out that i didnt put like 3 of the numbers in here and thats why it didn't work
    private static final String[] ONES = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
}
