class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max =0;
        int start = 0, end=0;

        while(end<s.length()){
            char c = s.charAt(end);
            if(!set.contains(c)){
                set.add(c);
                end++;
                max = Math.max(max, end-start);
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }

        } 
        return max;
    }
}