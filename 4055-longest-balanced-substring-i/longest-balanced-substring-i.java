class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                if (freq[c] == 0) distinct++;
                freq[c]++;

                int min = Integer.MAX_VALUE;
                int max = 0;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }

                if (min == max) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
