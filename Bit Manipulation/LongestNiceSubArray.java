//Approach -1 Brute Force for subarrays and bit manipulation 
// class LongestNiceSubArray {

//     public int longestNiceSubarray(int[] nums) {
//         int lengthOfNice = 1;
//         for (int i = 0; i < nums.length - lengthOfNice; i++) {
//             int currentLength = 1;
//             int usedBits = nums[i];
//             for (int j = i + 1; j < nums.length; j++) {
//                 if ((usedBits & nums[j]) == 0) {
//                     usedBits = usedBits | nums[j];
//                     currentLength++;
//                 } else {
//                     break;
//                 }
//             }
//             lengthOfNice = Math.max(lengthOfNice, currentLength);
//         }
//         return lengthOfNice;
//     }
// }
//Approach two - Sliding window and bit manipulation 
class LongestNiceSubArray {

    public int longestNiceSubarray(int[] nums) {
        int lengthOfNice = 0;
        int usedBits = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            while ((usedBits & nums[end]) != 0) {
                usedBits ^= nums[start];
                start++;
            }

            if ((usedBits & nums[end]) == 0) {
                usedBits |= nums[end];
                lengthOfNice = Math.max(lengthOfNice, end - start + 1);
            }
        }
        return lengthOfNice;
    }
}
