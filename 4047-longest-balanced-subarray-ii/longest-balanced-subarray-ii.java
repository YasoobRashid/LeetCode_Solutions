import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        
        SegmentTree st = new SegmentTree(n);
        
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastSeen.getOrDefault(val, -1);
            
            int diff = (val % 2 != 0) ? -1 : 1; 
            
            st.update(1, 0, n - 1, prev + 1, i, diff);
            
            int leftIdx = st.findFirstZero(1, 0, n - 1, 0, i);
            
            if (leftIdx != -1) {
                maxLen = Math.max(maxLen, i - leftIdx + 1);
            }
            
            lastSeen.put(val, i);
        }

        return maxLen;
    }

    static class SegmentTree {
        int[] minVal, maxVal, lazy;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            minVal = new int[4 * n];
            maxVal = new int[4 * n];
            lazy = new int[4 * n];
        }

        private void push(int node) {
            if (lazy[node] != 0) {
                lazy[2 * node] += lazy[node];
                minVal[2 * node] += lazy[node];
                maxVal[2 * node] += lazy[node];

                lazy[2 * node + 1] += lazy[node];
                minVal[2 * node + 1] += lazy[node];
                maxVal[2 * node + 1] += lazy[node];

                lazy[node] = 0;
            }
        }

        public void update(int node, int start, int end, int l, int r, int val) {
            if (l > end || r < start) return;

            if (l <= start && end <= r) {
                lazy[node] += val;
                minVal[node] += val;
                maxVal[node] += val;
                return;
            }

            push(node);
            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
            
            minVal[node] = Math.min(minVal[2 * node], minVal[2 * node + 1]);
            maxVal[node] = Math.max(maxVal[2 * node], maxVal[2 * node + 1]);
        }

        public int findFirstZero(int node, int start, int end, int l, int r) {
            if (l > end || r < start || minVal[node] > 0 || maxVal[node] < 0) {
                return -1;
            }

            if (start == end) {
                return (minVal[node] == 0) ? start : -1;
            }

            push(node);
            int mid = (start + end) / 2;
            
            int res = findFirstZero(2 * node, start, mid, l, r);
            if (res != -1) return res;
            
            return findFirstZero(2 * node + 1, mid + 1, end, l, r);
        }
    }
}