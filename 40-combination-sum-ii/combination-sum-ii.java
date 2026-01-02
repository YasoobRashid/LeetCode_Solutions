class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, result, target, 0 ,new ArrayList<>(), 0);
        return result;
    }

    void backtrack(int[] candidates, List<List<Integer>> result, int target, int sum, List<Integer>curr, int start){
        if(sum==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i = start; i<candidates.length; i++){
            if(i> start && candidates[i]==candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            backtrack(candidates, result, target, sum+candidates[i], curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}