public final class denton_9  {
	
	public static void main(String[] args) {
		System.out.println(new denton_9().run());
	}
	private static final int PERIMETER = 1000;
	
	public String run() {
		for (int a = 1; a < PERIMETER; a++) {
			for (int b = a + 1; b < PERIMETER; b++) {
				int c = PERIMETER - a - b;
				if (a * a + b * b == c * c) {
					return Integer.toString(a * b * c);
				}
			}
		}
		
        
        throw new AssertionError("boom wap");
	}
	
}