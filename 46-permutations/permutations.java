class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer>curr, boolean[] used){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length;i++){
            if(used[i]){
                continue;
            }

            used[i] = true;
            curr.add(nums[i]);

            backtrack(nums, res, curr, used);

            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}