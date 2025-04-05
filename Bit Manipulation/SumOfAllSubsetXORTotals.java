
class SumOfAllSubsetXORTotals {

    public static boolean checkBit(int n, int i) {
        return (n >> i) % 2 == 1;
    }

    public int subsetXORSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if (checkBit(i, j)) {
                    xor = xor ^ nums[j];
                }
            }
            sum = sum + xor;
        }
        return sum;
    }
}
