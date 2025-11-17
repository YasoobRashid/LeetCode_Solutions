class Solution {

    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length+1][amount+1];
        return solve(0, amount, coins);
    }

    int solve (int i , int amount, int[] coins){
        if(amount ==0){
            return 1;
        }

        if(i== coins.length|| amount<0){
            return 0;
        }

        if(dp[i][amount]!= null){
            return dp[i][amount];
        }

        int pick =0;

        if(coins[i]<=amount){
            pick = solve(i, amount - coins[i], coins);
        }

        int notpick = solve(i+1, amount, coins);

        return dp[i][amount]=pick +notpick;
    }
}