public class Solution {
    
    public boolean isMatch(String s, String p) {
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // An empty pattern can match an empty string.
        dp[0][0] = true;
        
        // Handle the case where the pattern starts with '*' which can match an empty string.
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // '*' can match empty sequence
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    // If the characters match or '?' is encountered
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can match zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        // Sample input
        String s = "adceb";
        String p = "*a*b";
        
        // Use Solution class to call the method
        Solution solution = new Solution();
        boolean result = solution.isMatch(s, p);
        
        // Output result
        System.out.println("Does the string match the pattern? " + result);
    }
}
