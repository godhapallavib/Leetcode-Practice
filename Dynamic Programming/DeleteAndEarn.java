// DP - Top down approach for delete and earn

import java.util.HashMap;

class DeleteAndEarn {

    HashMap<Integer, Integer> points = new HashMap<>();
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int maxPoints(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return points.getOrDefault(1, 0);
        }

        if (!dp.containsKey(n)) {
            dp.put(n, Math.max(maxPoints(n - 1), maxPoints(n - 2) + points.getOrDefault(n, 0)));
        }
        return dp.get(n);
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }

        return maxPoints(max);
    }
}
