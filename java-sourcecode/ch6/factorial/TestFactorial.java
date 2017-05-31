/*
 * File: TestFactorial.java
 * Author: Java, Java, Java
 * Description: This class performs a simple test of the
 *  factorial() method by passing it an illegal value. This
 *  will cause the program to throw and IllegealArgumentException.
 */

public class TestFactorial {

    /**
     * factorial(n) computes the factorial of n
     * @param n -- the integer who's factorial is computed
     * @return n!
     * Pre:  n >= 0
     * Post: factorial(n) = 1 if n = 0
     *                    = n * n-1 * n-2 * ... * 1, if n > 0
     */
    public int factorial(int n) {
	if (n < 0) 
	    throw new IllegalArgumentException("Factorial: " + n);
	if (n == 0)
	    return 1;
	else {
	    int f = 1; 
	    for (int k = n; k >= 1; k--)
		f = f * k;              
	    return f;                   
	}
    }

    /**
     * main() creates an instance of the TestFactorial class and
     *  invokes its factorial() method, passing it an illegal 
     *  argument of -1.
     */
    public static void main(String args[]) {
        TestFactorial test = new TestFactorial();
        System.out.println("Factorial (-1) = " + test.factorial(-1));       
    }
}
