class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return new ArrayList<>(res);    
    }

    void backtrack(int index, int[] nums, List<Integer> current){
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index+1, nums, current);

        current.remove(current.size()-1);

        backtrack(index+1, nums, current);
    }
}