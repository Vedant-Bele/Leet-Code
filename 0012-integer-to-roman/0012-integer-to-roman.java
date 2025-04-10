public class Solution {  // Renamed class to Solution

    // Array to store the Roman numeral symbols and their values
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        // Loop through each Roman numeral value
        for (int i = 0; i < VALUES.length; i++) {
            // While the current number is greater than or equal to the value
            while (num >= VALUES[i]) {
                roman.append(SYMBOLS[i]);  // Append the corresponding Roman numeral symbol
                num -= VALUES[i];  // Subtract the value from the number
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        // Example integer input
        int number = 1987;

        // Convert to Roman numeral
        Solution solution = new Solution();  // Create an instance of Solution
        String romanNumeral = solution.intToRoman(number);

        // Output the result
        System.out.println("The Roman numeral for " + number + " is: " + romanNumeral);
    }
}
