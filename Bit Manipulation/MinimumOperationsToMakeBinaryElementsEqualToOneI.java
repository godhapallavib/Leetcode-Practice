
class MinimumOperationsToMakeBinaryElementsEqualToOneI {

    public int minOperations(int[] nums) {
        int left = 0, n = nums.length;
        int swaps = 0;
        while (n - left >= 3) {
            if (nums[left] == 0) {
                swaps++;
                nums[left] = nums[left] ^ 1;
                nums[left + 1] = nums[left + 1] ^ 1;
                nums[left + 2] = nums[left + 2] ^ 1;
            }
            left++;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return swaps;
    }
}
