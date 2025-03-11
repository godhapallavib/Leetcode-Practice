
class AlternatingGroupsTwo {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length + k - 1, count = 0;
        int[] newColors = new int[n];
        for (int i = 0; i < colors.length; i++) {
            newColors[i] = colors[i];
        }
        for (int i = colors.length; i < n; i++) {
            newColors[i] = colors[i - colors.length];
        }

        int left = 0, right = 1;
        while (right < n) {
            if (newColors[right] == newColors[right - 1]) {
                left = right;
                right++;
                continue;
            }

            right++;
            if (right - left < k) {
                continue;
            }

            count++;
            left++;
        }
        return count;
    }
}
