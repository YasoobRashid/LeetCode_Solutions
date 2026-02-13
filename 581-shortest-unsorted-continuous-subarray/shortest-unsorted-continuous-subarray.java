class Solution {
    public int findUnsortedSubarray(int[] nums) {

        if(nums.length ==1 || nums.length==0){
            return 0;
        }
        int max = nums[0]; //previous number for compariign the element during right to left
        int min = nums[nums.length-1]; //previous number for compariign the element during left to right

        int st =-1; //start of subarray
        int end =-1; // end of subarray

        //going right to left to find end of the subarray
        for(int i =0; i<nums.length;i++){
            if(max>nums[i]){
                end = i;
            }
            else{
                max = nums[i];
            }
        }

        //going left to right to find start of the subarray
        for(int i =nums.length-2; i>=0; i--){
            if(min<nums[i]){
                st =i;
            }
            else{
                min = nums[i];
            }
        }

        if(st==-1) return 0; //means the array was already sorted otherwise it will ad +1 to it

        return end-st+1;


    }
}