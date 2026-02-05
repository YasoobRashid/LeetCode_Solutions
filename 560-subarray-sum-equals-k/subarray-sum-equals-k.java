class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();

        m.put(0,1);

        int cSum = 0;
        int count = 0;

        for(int num : nums){
            cSum +=num;

            if(m.containsKey(cSum - k )){
                count += m.get(cSum-k);
            }

            m.put(cSum, m.getOrDefault(cSum,0)+1);
        }

        return count;
    }
}