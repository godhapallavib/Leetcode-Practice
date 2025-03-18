
class LongestNiceSubArray {

    public int longestNiceSubarray(int[] nums) {
        int lengthOfNice = 1;
        for (int i = 0; i < nums.length - lengthOfNice; i++) {
            int currentLength = 1;
            int usedBits = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if ((usedBits & nums[j]) == 0) {
                    usedBits = usedBits | nums[j];
                    currentLength++;
                } else {
                    break;
                }
            }
            lengthOfNice = Math.max(lengthOfNice, currentLength);
        }
        return lengthOfNice;
    }
}
