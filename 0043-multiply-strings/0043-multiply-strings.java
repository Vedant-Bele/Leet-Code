public class Solution {
    public String multiply(String num1, String num2) {
        // If either of the numbers is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        
        // Create an array to store the result of multiplication
        int[] result = new int[len1 + len2];
        
        // Reverse iterate through both strings and multiply the digits
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                
                // Store the result at the current position
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        
        // Convert the result array to a string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2)); // Output: "56088"
    }
}
