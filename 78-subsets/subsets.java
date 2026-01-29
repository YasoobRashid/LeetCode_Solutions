class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    void helper(int nums[], int idx, List<Integer>curr){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(nums, idx+1, curr); //pick
         curr.remove(curr.size()-1);

        helper(nums, idx+1, curr); //notpick
    }
}