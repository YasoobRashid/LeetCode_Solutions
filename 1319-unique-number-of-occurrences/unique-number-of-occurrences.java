class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer,Integer> m= new HashMap<>();

        for(int num : arr){
            m.put(num, m.getOrDefault(num,0)+1);
        }

        Set <Integer> s= new HashSet<>();

        for(int freq : m.values()){
            if(!s.add(freq)){
                return false;
            }
        }

        return true;
    }
}