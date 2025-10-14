class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen= Integer.MAX_VALUE;
        int sum =0;
        int start =0;

        for(int end=0; end<nums.length;end++){
            sum += nums[end];

            while(sum>=target){
                minLen = Math.min(minLen, end - start +1);
                sum -= nums[start];
                start++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        return minLen ;
    }
}