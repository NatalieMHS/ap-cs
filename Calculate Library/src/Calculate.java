/* Natalie Suboc
 * September 9, 2017
 * Self-written Math library 
 * Contains a series of methods to do basic math functions */


public class Calculate {
	
	// squares the input
	public static int square(int operand) {
		return operand * operand;
	}
	
	// cubes the input
	public static int cube(int num) {
		return num * num * num;
	}
	
	// takes the average of two numbers
	public static double average(double num1, double num2) {
		return ((num1 + num2) / 2);
	}
	
	// takes the average of three numbers
	public static double average(double num1, double num2, double num3) {
		return ((num1 + num2 + num3) / 3);
	}
	
	// converts a radian value to degrees
	public static double toDegrees(double radian) {
		return (radian * (180 / 3.14159));
	}
	
	// converts a degree value to radians
	public static double toRadians(double degree) {
		return (degree * (3.14159 / 180));
	}
	
	// takes the a, b, and c from the equation ax^2 + bx + c and returns the discriminant
	public static double discriminant(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	// converts a mixed number into an improper fraction
	// can also handle negative mixed numbers 
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		int improper = (wholeNum * denominator);
		if (numerator < 0 || denominator < 0) {
			throw new IllegalArgumentException("The numerator or denominator of a mixed number cannot be negative.");
		}
		if (wholeNum > 0) {
			improper += numerator;
		} else {
			improper -= numerator;
		}
		return improper + "/" + denominator;
	}
	
	// converts an improper fraction into a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		int mixed = numerator / denominator;
		int newNumerator = numerator % denominator;
		return mixed + " " + (int) absValue(newNumerator) + "/" + (int) absValue(denominator);
	}
	
	/* takes a binomial (ax+b)(cx+d) and foils it
	 * returns the binomial in the form ax^2 + bx + c
	 */
	public static String foil(int binomialA, int binomialB, int binomialC, int binomialD, String varName) {
		int a = binomialA * binomialC;
		int b = (binomialA * binomialD) + (binomialB * binomialC);
		int c = binomialB * binomialD;
		return a + varName + "^2 + " + b + varName + " + " + c;
	}
	
	// determines if the dividend can be equally divided by the divisor
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Error: Cannot be divided by 0.");
		}
		return dividend % divisor == 0;
	}
	
	// takes a number and returns the absolute value
	public static double absValue(double operand) {
		if (operand < 0) {
			return -operand;
		} else {
			return operand;
		}
	}
	
	// takes two numbers and returns the largest of the two
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}

	// takes three numbers and returns the largest of the three
	public static double max(double num1, double num2, double num3) {
		if (num1 >= num2 && num1 >= num3) {
			return num1;
		} else if (num2 >= num3 && num2 >= num1) {
			return num2;
		} else if (num3 >= num1 && num3 >= num1) {
			return num3;
		} else {
			return num1;
		}
	}
	
	// takes two integers and returns the smallest one
	public static int min(int num1, int num2) {
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	// rounds a number to two decimal places
	public static double round2(double num) {
		int noDecimalsNum = (int) (num * 1000); // removes decimals beyond the thousandths place
		int thousandthDigit = noDecimalsNum % 10;
		noDecimalsNum /= 10;
		// increments if number is positive, decrements if number is negative
		if (thousandthDigit >= 5 && noDecimalsNum > 0) {
			noDecimalsNum += 1;
		} else if (thousandthDigit <= -5 && noDecimalsNum < 0) {
			noDecimalsNum -= 1;
		}
		return noDecimalsNum / 100.0; // returns the rounded value and makes it a double
	}
	
	// takes a base and an exponent power and calculates the exponent's value
	public static double exponent(double base, int power) {
		double operand = base;
		double result;
		if (power < 0) {
			throw new IllegalArgumentException("The exponent cannot be negative.");
		}
		if (power == 0) {
			result = base;
		} else {
			for(int i = 0; i < power - 1; i++) {
				operand *= base;
			}
			result = operand;
		}
		return result;
	}
	
	// evalulates the factorial of an integer
	public static int factorial(int operand) {
		if (operand < 0) {
			throw new IllegalArgumentException("The value of the factorial cannot be negative.");
		}
		int factorialValue = 1;
		for (int i = 0; i < operand; i++) {
			factorialValue *= i + 1;
		}
		return factorialValue;
	}
	
	// evaluates whether a number is a prime number
	public static boolean isPrime(int num) {
		boolean prime = true;
		// doesn't test to see if the number is divisible by itself and 1,
		// because it can still be prime even if its divisible by those numbers
		for (int i = 2; i < num; i++) {
			if (isDivisibleBy(num, i)) {
				prime = false;
			}
		}
		return prime;
	}
	
	// evaluates the greatest common factor of two numbers
	public static int gcf(int num1, int num2) {
		int gcf = 1;
		for (int i = 1; i <= min(num1, num2); i++) {
			if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
				if (gcf < i) {
					gcf = i;
				}
			}
		}
		return gcf;
	}
	
	// takes a number and returns its square root to two decimals
	public static double sqrt(double num) {
		double guess = 0.1;
		double guessSqrt = 0;
		if (num < 0) {
			throw new IllegalArgumentException("The square root of " + num + " is imaginary.");
		}
		while (round2(guessSqrt * guessSqrt) != num) {
			guessSqrt = 0.5 * (num / guess + guess);
			guess += 0.1;
		}
		return round2(guessSqrt);
	}
	
	// takes the a, b, and c of a quadratic equation in the form ax^2 + bx + c
	// and returns its roots
	public static String quadForm(int a, int b, int c) {
		double discr = discriminant(a, b, c);
		if (discr < 0) {
			return "no real roots";
		} else if (discr == 0) {
			double root = (-b + sqrt(discr)) / (2 * a);
			return round2(root) + "";
		} else {
			double posRoot = (-b + sqrt(discr)) / (2 * a);
			double negRoot = (-b - sqrt(discr)) / (2 * a);
			return round2(negRoot) + " and " + round2(posRoot);
		}
	}
}
