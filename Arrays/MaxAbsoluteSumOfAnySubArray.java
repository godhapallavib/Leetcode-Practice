
class MaxAbsoluteSumOfAnySubArray {

    public int maxAbsoluteSum(int[] nums) {
        int maxResult = nums[0], maxEnding = nums[0];
        int minResult = nums[0], minEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxResult = Math.max(maxResult, maxEnding);
            minEnding = Math.min(minEnding + nums[i], nums[i]);
            minResult = Math.min(minResult, minEnding);
        }
        return Math.max(Math.abs(maxResult), Math.abs(minResult));
    }
}
