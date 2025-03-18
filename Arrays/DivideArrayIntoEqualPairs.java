
import java.util.HashMap;

class DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (int num : hm.keySet()) {
            if (hm.get(num) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
