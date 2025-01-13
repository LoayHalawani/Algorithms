public class Recursion {
	
	static String reverseWord(String word) {
		if(word.isEmpty()) {
			return word;
		}
		return reverseWord(word.substring(1)) + word.charAt(0);
	}

	static int exponent(int n, int m) {
		if(m == 1) {
			return n;
		}
		return n * exponent(n, m - 1);
	}

	static int factorial(int number) {
		if(number == 1) {
			return number;
		}
		return number * factorial(number - 1);
	}

	static boolean isPalindrome(String word) {
		if(word.isEmpty() || word.length() == 1) {
			return true;
		}
		if(word.charAt(0) == word.charAt(word.length() - 1)) {
			return isPalindrome(word.substring(1, word.length() - 1));
		}
		return false;
	}

	static int fibonacci(int number) {
		if(number == 0) {
			return 0;
		}
		if(number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static void main(String[] args) {
		System.out.println("Reverse of Hello: " + reverseWord("Hello"));
		System.out.println("2^2 = " + exponent(2, 2));
		System.out.println("4! = " + factorial(4));
		String res = isPalindrome("bob") ? "Yes" : "No";
		System.out.println("Is \"bob\" a palindrome? " + res);
		res = isPalindrome("alice") ? "Yes" : "No";
		System.out.println("Is \"alice\" a palindrome? " + res);
		System.out.println("F(10) = " + fibonacci(10));
	}
}
