class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen = 0; 

        for(int l = 0; l<nums.length; l++){
            Set<Integer> even = new HashSet<>();
            Set <Integer> odd = new HashSet<>();

            for(int r = l ; r<nums.length;r++){
                if(nums[r]%2==0){
                    even.add(nums[r]);
                }
                else{
                    odd.add(nums[r]);
                }

                if(even.size()== odd.size()){
                    maxLen = Math.max(maxLen, r-l+1);
                }
            }
        }

        return maxLen;
    }
}