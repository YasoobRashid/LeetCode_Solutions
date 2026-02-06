class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //prefix sum and hashmap
        HashMap <Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        int cSum = 0;
        int count = 0;

        for(int num :nums){
            cSum += num;

            if(map.containsKey(cSum-goal)){
                count += map.get(cSum - goal);
            }

            map.put(cSum, map.getOrDefault(cSum, 0)+1);
        }

        return count;
    }
}