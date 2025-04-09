public class Solution {
    public boolean isMatch(String s, String p) {
        // Create a DP table with (len(s) + 1) rows and (len(p) + 1) columns
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // Base case: empty string matches with empty pattern
        dp[0][0] = true;
        
        // Handle cases where pattern starts with something like a* or a*b* that can match empty string
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can either match zero occurrences or one or more occurrences of the previous character
                    dp[i][j] = dp[i][j - 2];  // '*' matches zero occurrence of the previous char
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];  // '*' matches one or more occurrences of the previous char
                    }
                }
            }
        }
        
        // The result will be in the bottom-right corner of the DP table
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        System.out.println(solution.isMatch("aa", "a*"));  // Expected: true
        
        // Test case 2
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));  // Expected: false
        
        // Test case 3
        System.out.println(solution.isMatch("ab", ".*"));  // Expected: true
        
        // Test case 4
        System.out.println(solution.isMatch("aab", "c*a*b"));  // Expected: true
        
        // Test case 5
        System.out.println(solution.isMatch("ab", ".*c"));  // Expected: false
    }
}
