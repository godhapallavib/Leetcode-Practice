
import java.util.HashMap;

class HouseRobber {

    HashMap<Integer, Integer> dp = new HashMap<>();
    int nums[];

    public int dpfun(int n) {
        if (n == 0) {
            return nums[0];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (!dp.containsKey(n)) {
            dp.put(n, Math.max(dpfun(n - 1), nums[n] + dpfun(n - 2)));
        }
        return dp.get(n);
    }

    public int rob(int[] nums) {
        this.nums = nums;
        return dpfun(nums.length - 1);
    }
}
