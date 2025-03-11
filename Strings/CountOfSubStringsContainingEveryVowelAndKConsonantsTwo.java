
import java.util.HashMap;

class CountOfSubStringsContainingEveryVowelAndKConsonantsTwo {

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public long countOfSubstrings(String word, int k) {
        long result = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        int nextConsonant[] = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        while (right < word.length()) {
            char newLetter = word.charAt(right);
            if (isVowel(newLetter)) {
                vowelCount.put(newLetter, vowelCount.getOrDefault(newLetter, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                char leftLetter = word.charAt(left);
                if (isVowel(leftLetter)) {
                    vowelCount.put(leftLetter, vowelCount.get(leftLetter) - 1);
                    if (vowelCount.get(leftLetter) == 0) {
                        vowelCount.remove(leftLetter);
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }

            while (left < word.length() && consonantCount == k && vowelCount.keySet().size() == 5) {
                result += nextConsonant[right] - right;
                char leftLetter = word.charAt(left);
                if (isVowel(leftLetter)) {
                    vowelCount.put(leftLetter, vowelCount.get(leftLetter) - 1);
                    if (vowelCount.get(leftLetter) == 0) {
                        vowelCount.remove(leftLetter);
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
