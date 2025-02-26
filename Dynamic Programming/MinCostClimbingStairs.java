// DP - Bottom up approach 

class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        dp[0] = cost[0];
        if (cost.length == 1) {
            return dp[0];
        }

        dp[1] = cost[1];
        dp[cost.length] = 0;

        for (int i = 2; i <= cost.length; i++) {
            if (i == cost.length) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }

        }

        return dp[cost.length];
    }
}
