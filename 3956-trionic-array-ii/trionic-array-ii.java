class Solution {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long res = (long)-1e16;

        for (int i = 1; i < n - 2; i++) {

            int a = i, b = i;
            long mid = nums[i];

            while (b + 1 < n && nums[b + 1] < nums[b]) {
                mid += nums[b + 1];
                b++;
            }
            if (b == i) continue;

            int valley = b;

            long leftSum = 0, rightSum = 0;
            long bestLeft = Long.MIN_VALUE;
            long bestRight = Long.MIN_VALUE;

            while (a - 1 >= 0 && nums[a - 1] < nums[a]) {
                leftSum += nums[a - 1];
                bestLeft = Math.max(bestLeft, leftSum);
                a--;
            }
            if (a == i) continue;

            while (b + 1 < n && nums[b + 1] > nums[b]) {
                rightSum += nums[b + 1];
                bestRight = Math.max(bestRight, rightSum);
                b++;
            }
            if (b == valley) continue;

            res = Math.max(res, bestLeft + mid + bestRight);

            i = b - 1; 
        }

        return res;
    }
}
