import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {  // Rename here to match the driver code
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the array to handle duplicates easily
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        // If target is 0, we have found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If the current number is greater than the remaining target, break
            if (candidates[i] > target) {
                break;
            }

            // Include the current number and recurse
            currentCombination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, currentCombination, result);  // i + 1 to use each number once
            // Backtrack: remove the last element
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 5};
        int target = 8;

        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        // Printing the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
