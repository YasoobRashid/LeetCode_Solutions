class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;

    }

    void backtrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result, int sum){
        if(sum==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i = start; i<candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(candidates, target, i, curr, result, sum+candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}