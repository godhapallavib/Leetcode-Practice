
class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0, majorityEle = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majorityEle = nums[i];
            }

            if (nums[i] == majorityEle) {
                count++;
            } else {
                count--;
            }
        }
        return majorityEle;
    }
}
