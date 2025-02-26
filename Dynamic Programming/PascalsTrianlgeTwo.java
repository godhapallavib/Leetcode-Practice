//DP - Bottom up Approach for Pascal's triangle II 

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleTwo {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return dp.get(rowIndex);
    }
}
