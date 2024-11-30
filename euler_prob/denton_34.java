public final class denton_34 {
	
	public static void main(String[] args) {
		System.out.println(new denton_34().run());
	}
	
	public String run() {
		int sum = 0;
		for (int i = 3; i < 10000000; i++) {
			if (i == factorialDigitSum(i))
				sum += i;
		}
		return Integer.toString(sum);
	}
	
	
//bla bla bla math bs and what not, anyway how was your day mr.teacher assistant? goin well im hope. 
//hey im the guy that was contomplating if i was dyslexic durning my data structures midterm if you remeber that
//just realized i made a typo...but im not gonna fix it out of spite, for whom? couldn't tell you
	private static int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
	private static int factorialDigitSum(int x) {
		int sum = 0;
		while (x != 0) {
			sum += FACTORIAL[x % 10];
			x /= 10;
		}
		return sum;
	}
	
}