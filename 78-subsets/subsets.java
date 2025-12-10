class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    void backtrack(int index, int[] nums, List<Integer> current){
        if(index == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        //pick
        current.add(nums[index]);
        backtrack(index+1, nums, current);
        current.remove(current.size()-1);

        //notpick
        backtrack(index+1,nums, current);
    }
}
