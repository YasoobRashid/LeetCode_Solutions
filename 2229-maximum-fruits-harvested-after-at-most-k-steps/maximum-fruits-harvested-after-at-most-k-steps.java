class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, currSum = 0;

        for (int right = 0; right < n; right++) {
            currSum += fruits[right][1];

            while (left <= right && !isWithinKSteps(fruits, left, right, startPos, k)) {
                currSum -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, currSum);
        }

        return maxFruits;


    }

    private boolean isWithinKSteps(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int cost1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int cost2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(cost1, cost2) <= k;
    }
}