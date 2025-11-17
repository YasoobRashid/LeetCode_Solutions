class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length+1][amount+1];
        int ans = solve(coins, amount, 0);
        if(ans >= 1000000){
            return -1;
        }
        return ans;

    }

    private int solve(int[] coins, int amount, int i) {
        if (amount == 0) return 0;

        if (i == coins.length) return 1000000;

        if (dp[i][amount] != null) return dp[i][amount];

        int notPick = solve(coins, amount, i + 1);

        int pick = 1000000;
        if (amount >= coins[i]) {
            pick = 1 + solve(coins, amount - coins[i], i); 
        }

        return dp[i][amount] = Math.min(pick, notPick);
    }
}