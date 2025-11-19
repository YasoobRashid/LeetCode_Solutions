class Solution {
    Integer[] dp;
    boolean[] travel;
    int maxDay;
    public int mincostTickets(int[] days, int[] costs) {

        travel = new boolean[366];

        for(int d : days){
            travel[d] = true;
        }
        
        maxDay = days[days.length-1];
        dp = new Integer[maxDay+1];

        return solve(1, costs);
    }

    int solve(int day, int[] costs){
        if(day>maxDay){
            return 0;
        }

        if(dp[day] != null) return dp[day];

        if(!travel[day]) {
            dp[day] = solve(day + 1,costs);
            return dp[day];
        }

        int cost1  = costs[0] + solve(day + 1,costs);
        int cost7  = costs[1] + solve(day + 7,costs);
        int cost30 = costs[2] + solve(day + 30,costs);

        return dp[day] = Math.min(cost1, Math.min(cost7, cost30));
    }
}