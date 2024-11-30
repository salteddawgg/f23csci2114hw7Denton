public final class denton_19 {
	
	public static void main(String[] args) {
		System.out.println(new denton_19().run());
	}
	public String run() {
		int count = 0;
		for (int y = 1901; y <= 2000; y++) {
			for (int m = 1; m <= 12; m++) {
				if (dayOfWeek(y, m, 1) == 0)  // Sunday = zero
					count++;
			}
		}
		return Integer.toString(count);
	}
	

    private static int dayOfWeek(int year, int month, int day) {
		if (year < 0 || year > 10000 || month < 1 || month > 12 || day < 1 || day > 31)
			throw new IllegalArgumentException();
		
		// Zeller algo my belovid
		int m = (month - 3 + 4800) % 4800;
		int y = (year + m / 12) % 400;
		m %= 12;
		return (y + y/4 - y/100 + (13 * m + 2) / 5 + day + 2) % 7;
	}
	
}