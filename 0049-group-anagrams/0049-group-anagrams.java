import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a character array, sort it and then convert it back to a string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // If the key is already in the map, add the string to the corresponding list
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        // Return the values of the map (list of anagrams)
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // This will be your driver code
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        // Print the result
        System.out.println(result);
    }
}
