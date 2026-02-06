class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal-1);
    }

    int solve(int[] nums, int goal){
        int count =0;
        int i = 0;
        int sum =0;

        for(int j = 0; j <nums.length; j++){
            if(goal<0) return 0;
            sum += nums[j];

            while(i<nums.length &&  sum>goal){
                sum -= nums[i];
                i++;
            }
            count += j-i+1 ;
        } 


        return count;
    }
}