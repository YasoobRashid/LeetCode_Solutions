class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long sum1=0, sum2=0;
        long mod = 1_000_000_007L;

        while( i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                sum1 += nums1[i++];
            } 
            else if(nums1[i]==nums2[j]){
                long maxSum = Math.max(sum1, sum2)+ nums1[i];
                sum1 = maxSum;
                sum2 = maxSum;
                i++;
                j++;
            }
            else{
                sum2 += nums2[j++];
            }
        }

        while(i<nums1.length) {
            sum1 += nums1[i++];
        }
        while(j<nums2.length){
            sum2 +=nums2[j++];
        }

        return (int)(Math.max(sum1,sum2)%mod);
    }
}