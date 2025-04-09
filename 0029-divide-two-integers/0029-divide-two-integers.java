public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the edge case where the result would overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;  // overflow case
        }

        // Handle the sign of the result
        boolean negative = (dividend < 0) != (divisor < 0);

        // Work with absolute values to simplify the logic
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // Repeated subtraction using bit shifting (doubling the divisor)
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;  // Double the divisor
                multiple <<= 1;     // Double the multiple
            }

            absDividend -= tempDivisor;  // Subtract the large divisor
            quotient += multiple;       // Add the multiple to the quotient
        }

        // If the result should be negative, negate the quotient
        if (negative) {
            quotient = -quotient;
        }

        // Ensure the quotient is within the 32-bit integer range
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.divide(10, 3)); // Output: 3
        System.out.println(solution.divide(7, -3)); // Output: -2
        System.out.println(solution.divide(Integer.MIN_VALUE, -1)); // Output: 2147483647 (overflow case)
        System.out.println(solution.divide(Integer.MIN_VALUE, 1));  // Output: -2147483648
    }
}
