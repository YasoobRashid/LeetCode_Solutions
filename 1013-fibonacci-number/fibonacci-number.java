class Solution {
    int[] dp;
    public int fib(int n) {
        
        dp = new int[n+1];
        Arrays.fill(dp,-1);

        return helper(n);   
    }

    public int helper(int n){
        if(n==0||n==1){
            return n;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = helper(n-1) + helper(n-2);
        return dp[n];
    }
}