class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int i =0; 
        int j = nums.length-1;

        int idx = nums.length-1;

        while(i<=j){
            int l = nums[i]*nums[i];
            int r = nums[j]*nums[j];

            if(l>r){
                res[idx--]=l;
                i++;
            }
            else{
                res[idx--]=r;
                j--;
            }

        }

        return res;
    }
}