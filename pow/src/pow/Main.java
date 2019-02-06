package pow;

public class Main {

	public static void main(String[] args) {
		
		int base = 2;
		int exp = 3;
		
		double mathPow = Math.pow(base, exp);
		int myPow = myPow(base, exp);
		int myRecPow = myRecursivePow(base, exp);
				
		System.out.println("Pow results");
		System.out.println(mathPow);
		System.out.println(myPow);
		System.out.println(myRecPow);
	}
		
	private static int myPow(int base, int exp) {
		
		if (exp == 0)
			return 1;
		
		int result = 1;
		
		for (int i = 1; i <= exp; i++) {
			result = result * base;
		}
		
		return result;
	}
	
	private static int myRecursivePow(int base, int exp) {
		
		if (exp == 0)
			return 1;
		
		return myRecursivePow(base, exp - 1) * base;
	}
	
}
