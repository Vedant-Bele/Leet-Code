public class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int param_1 = 121; // You can replace this with any integer value
        boolean ret = solution.isPalindrome(param_1);
        System.out.println(param_1 + " is palindrome? " + ret);
    }
}
