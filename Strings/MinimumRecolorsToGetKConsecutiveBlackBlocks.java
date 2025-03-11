
class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int minRecolor = Integer.MAX_VALUE, whiteCount = 0;
        int left = 1, right = k;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minRecolor = Math.min(minRecolor, whiteCount);
        while (right < blocks.length()) {
            if (blocks.charAt(left - 1) == 'W') {
                whiteCount--;
            }

            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }

            minRecolor = Math.min(minRecolor, whiteCount);

            left++;
            right++;
        }
        return minRecolor;
    }
}
