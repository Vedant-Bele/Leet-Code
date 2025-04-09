public class Solution { // Rename CombinationSum to Solution

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, currentCombination, result);
        return result;
    }
    
    private void findCombinations(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            currentCombination.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution cs = new Solution(); // Call the Solution class
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> combinations = cs.combinationSum(candidates, target);
        
        System.out.println("Combinations summing to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
