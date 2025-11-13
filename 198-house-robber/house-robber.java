class Solution {

    Integer[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1];
        return helper(n-1, nums);
    }

    public int helper (int i, int[] nums){
        if(i==0){
            return nums[0];
        }

        if(i==1){
            return Math.max(nums[0], nums[1]);
        }

        if(dp[i]!=null){
            return dp[i];
        }

        int pick = nums[i] + helper(i-2,nums);

        int notPick = helper (i-1, nums);

        return dp[i]= Math.max(pick,notPick);
    }
}