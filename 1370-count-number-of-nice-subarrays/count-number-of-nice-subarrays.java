class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k)-solve(nums,k-1);
    }

    int solve(int[] nums, int k){
        int oddC = 0;
        int res = 0; 
        int left = 0;

        for(int right = 0; right<nums.length;right++){
            if(nums[right]%2!=0){
                oddC++;
            }

            while(oddC > k ){
                if(nums[left]%2 != 0){
                    oddC -=1;
                }
                left++;
            }

            res+= right -left+1;
        }

        return res;
    }
}