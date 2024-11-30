import java.math.BigInteger;


public final class denton_5  {
	
	public static void main(String[] args) {
		System.out.println(new denton_5().run());
	}
	public String run() {
		BigInteger allLcm = BigInteger.ONE;
		for (int i = 1; i <= 20; i++)
			allLcm = lcm(BigInteger.valueOf(i), allLcm);
		return allLcm.toString();
	}
	
	
	private static BigInteger lcm(BigInteger x, BigInteger y) {
		return x.divide(x.gcd(y)).multiply(y);
	}
}