// Solution class with the myPow method
public class Solution {
    
    // Function to calculate x raised to the power n
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;  // x^0 is always 1
        }

        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return power(x, n);
    }

    // Helper function to perform fast exponentiation
    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);  // Recur for n/2
        if (n % 2 == 0) {
            return half * half;  // If n is even
        } else {
            return half * half * x;  // If n is odd
        }
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        double x = 2.0;
        int n = 10;
        System.out.println("Result of " + x + " raised to the power " + n + " is: " + solution.myPow(x, n));

        // Example with negative exponent
        x = 2.0;
        n = -3;
        System.out.println("Result of " + x + " raised to the power " + n + " is: " + solution.myPow(x, n));
    }
}
