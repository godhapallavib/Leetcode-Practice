// DP- Top down Approach

class ClimbingStairs {

    int arr[] = new int[46];

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (arr[n] == 0) {
            arr[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return arr[n];
    }
}
