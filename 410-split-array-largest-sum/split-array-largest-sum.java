class Solution {
    public int splitArray(int[] nums, int k) {
        int lo =0;
        int hi =0;

        for(int num:nums){
            lo = Math.max(lo,num); //max element
            hi += num; //totalsum
        }

        while(lo<hi){
            int mid = lo+(hi-lo)/2;

            if(canSplit(nums, k , mid)){
                hi = mid; // try smaller subarrays
            }
            else{
                lo = mid+1; //need larger max
            }
        }

        return lo;
    }

    boolean canSplit(int[] nums, int k , int maxSum){
        int subarrays =1;
        int currSum =0;

        for(int num:nums){
            if(currSum+num>maxSum){
                subarrays++;
                currSum= num;
            }
            else{
                currSum+=num;
            }
        }

        return subarrays <= k; 
    }
} 