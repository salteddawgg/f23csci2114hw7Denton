import java.util.Arrays;


public final class denton_52 {
	
	public static void main(String[] args) {
		System.out.println(new denton_52().run());
	}
	
	


	public String run() {
		for (int i = 1; ; i++) {
			if (i > Integer.MAX_VALUE / 6)
				throw new ArithmeticException("Overflow");
			if (multiplesHaveSameDigits(i))
				return Integer.toString(i);
		}
	}
	
	
	private static boolean multiplesHaveSameDigits(int x) {
		for (int i = 2; i <= 6; i++) {
			if (!Arrays.equals(toSortedDigits(x), toSortedDigits(i * x)))
				return false;
		}
		return true;
	}
	


//      :)    o_0   @_@ *_*






	private static char[] toSortedDigits(int x) {
		char[] result = Integer.toString(x).toCharArray();
		Arrays.sort(result);
		return result;
	}
	
}