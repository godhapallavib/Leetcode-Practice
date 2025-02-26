//DP - Bottom up approach for Pascal's Triangle

import java.util.*;

class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    innerList.add(1);
                } else if (j == i) {
                    innerList.add(1);
                } else {
                    innerList.add((dp.get(i - 1).get(j)) + (dp.get(i - 1).get(j - 1)));
                }
            }
            dp.add(innerList);
        }
        return dp;
    }
}
