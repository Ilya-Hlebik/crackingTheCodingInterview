package Ch_01_Arrays_and_Strings.Q1_01_Is_Unique.run2;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
        System.out.println();
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars2(word));
        }
    }

    private static boolean isUniqueChars(String word) {
        return IntStream.range(0, word.length()).mapToObj(word::charAt).distinct().count() == word.length();
    }

    private static boolean isUniqueChars2(String word) {
        if (word.length() > 128) {
            return false;
        }
        char[] chars = word.toCharArray();
        int[] letters = new int[128];
        for (char c : chars) {
            letters[c]++;
            if (letters[c] > 1) {
                return false;
            }
        }
        return true;
    }
}
