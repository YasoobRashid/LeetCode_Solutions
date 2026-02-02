class Solution {
    private TreeMap<Integer, Integer> small;
    private TreeMap<Integer, Integer> large;
    private long currentSum;
    private int smallSize;
    private int largeSize;
    
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        
        small = new TreeMap<>();
        large = new TreeMap<>();
        currentSum = 0;
        smallSize = 0;
        largeSize = 0;
        long minCost = Long.MAX_VALUE;
        
        int windowEnd = Math.min(n - 1, 1 + dist);
        for (int i = 1; i <= windowEnd; i++) {
            add(nums[i], k - 1);
        }
        
        if (smallSize == k - 1) {
            minCost = nums[0] + currentSum;
        }
        
        for (int right = windowEnd + 1; right < n; right++) {
            int left = right - dist - 1;
            
            add(nums[right], k - 1);
            remove(nums[left], k - 1);
            
            if (smallSize == k - 1) {
                minCost = Math.min(minCost, nums[0] + currentSum);
            }
        }
        
        return minCost;
    }
    
    private void add(int val, int target) {
        if (smallSize < target || 
            (smallSize == target && !small.isEmpty() && val < small.lastKey())) {
            small.put(val, small.getOrDefault(val, 0) + 1);
            currentSum += val;
            smallSize++;
            
            if (smallSize > target) {
                int maxSmall = small.lastKey();
                currentSum -= maxSmall;
                
                int count = small.get(maxSmall);
                if (count == 1) {
                    small.remove(maxSmall);
                } else {
                    small.put(maxSmall, count - 1);
                }
                smallSize--;
                
                large.put(maxSmall, large.getOrDefault(maxSmall, 0) + 1);
                largeSize++;
            }
        } else {
            large.put(val, large.getOrDefault(val, 0) + 1);
            largeSize++;
        }
    }
    
    private void remove(int val, int target) {
        if (small.containsKey(val)) {
            currentSum -= val;
            
            int count = small.get(val);
            if (count == 1) {
                small.remove(val);
            } else {
                small.put(val, count - 1);
            }
            smallSize--;
            
            if (smallSize < target && largeSize > 0) {
                int minLarge = large.firstKey();
                
                int largeCount = large.get(minLarge);
                if (largeCount == 1) {
                    large.remove(minLarge);
                } else {
                    large.put(minLarge, largeCount - 1);
                }
                largeSize--;
                
                small.put(minLarge, small.getOrDefault(minLarge, 0) + 1);
                currentSum += minLarge;
                smallSize++;
            }
        } else if (large.containsKey(val)) {
            int count = large.get(val);
            if (count == 1) {
                large.remove(val);
            } else {
                large.put(val, count - 1);
            }
            largeSize--;
        }
    }
}