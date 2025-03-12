
class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public int lowerBound(int[] nums) {
        int low = 0, high = nums.length - 1;
        int index = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else if (nums[mid] >= 0) {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public int upperBound(int[] nums) {
        int low = 0, high = nums.length - 1;
        int index = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= 0) {
                low = mid + 1;
            } else if (nums[mid] > 0) {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public int maximumCount(int[] nums) {
        int lowbound = lowerBound(nums);
        int highbound = upperBound(nums);

        return Math.max(lowbound, nums.length - highbound);
    }
}
