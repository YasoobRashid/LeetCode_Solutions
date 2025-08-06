public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);       
        int high = getSum(weights);      

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }

        return low;
    }

    private boolean isPossible(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += weight;

            if (dayCount > days) {
                return false;
            }
        }

        return true;
    }

    private int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int total = 0;
        for (int w : weights) {
            total += w;
        }
        return total;
    }
}
