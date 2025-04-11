import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, current, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // If the current permutation has the same length as nums, we add it to the result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try every number in the array
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // Skip if the number has already been used
            }
            used[i] = true; // Mark the number as used
            current.add(nums[i]); // Add the number to the current permutation
            backtrack(nums, used, current, result); // Recur with the updated state
            current.remove(current.size() - 1); // Remove the last element to backtrack
            used[i] = false; // Unmark the number as used for the next iteration
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        
        // Print the permutations
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
