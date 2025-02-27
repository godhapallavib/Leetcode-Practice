
class LongestCommonSubsequence {

    int[][] memo;
    String text1, text2;

    public int dp(int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new int[text1.length() + 1][text2.length() + 1];
        this.text1 = text1;
        this.text2 = text2;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                this.memo[i][j] = -1;
            }
        }
        return dp(0, 0);
    }
}
