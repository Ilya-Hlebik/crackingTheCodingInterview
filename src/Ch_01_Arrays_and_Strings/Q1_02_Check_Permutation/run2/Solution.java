package Ch_01_Arrays_and_Strings.Q1_02_Check_Permutation.run2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    private static boolean permutation(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] chars1 = word1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }

    private static boolean permutation2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        boolean[] chars = new boolean[128];
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            chars[c1] = !chars[c1];
            chars[c2] = !chars[c2];
        }
        for (boolean aChar : chars) {
            if (aChar) {
                return false;
            }
        }
        return true;
    }
}
