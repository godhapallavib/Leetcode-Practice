
class MaximumScoreFromPerformingMultiplicationOperations {

    int n, m;

    public int dp(int[][] memo, int[] nums, int[] multipliers, int left, int k) {
        if (k == m) {
            return 0;
        }

        if (memo[k][left] != 0) {
            return memo[k][left];
        }

        int right = n - 1 - (k - left);
        memo[k][left] = Math.max(nums[left] * multipliers[k] + dp(memo, nums, multipliers, left + 1, k + 1),
                nums[right] * multipliers[k] + dp(memo, nums, multipliers, left, k + 1));

        return memo[k][left];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        int memo[][] = new int[m][m];
        return dp(memo, nums, multipliers, 0, 0);
    }
}
