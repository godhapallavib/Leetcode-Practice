
import java.util.HashMap;

class NumberOfSubStringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int result = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char letter = s.charAt(right);
            hm.put(letter, hm.getOrDefault(letter, 0) + 1);
            if (hm.keySet().size() == 3) {
                result += s.length() - right;
                left++;
                hm.put(s.charAt(left - 1), hm.get(s.charAt(left - 1)) - 1);
                if (hm.get(s.charAt(left - 1)) == 0) {
                    hm.remove(s.charAt(left - 1));
                }
            }

            while (hm.keySet().size() == 3 && right - left + 1 >= 3) {
                if (hm.keySet().size() == 3) {
                    result += s.length() - right;
                }
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                if (hm.get(s.charAt(left)) == 0) {
                    hm.remove(s.charAt(left));
                }
                left++;
            }

            right++;
        }
        return result;
    }
}
