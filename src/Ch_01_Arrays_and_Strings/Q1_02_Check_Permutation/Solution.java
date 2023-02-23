package Ch_01_Arrays_and_Strings.Q1_02_Check_Permutation;

import java.util.Arrays;

public class Solution {

    public static boolean permutation(String s, String t) {
        if (t.length() != s.length()){
            return false;
        }
        char[] charsA = s.toCharArray();
        Arrays.sort(charsA);
        char[] charsB = t.toCharArray();
        Arrays.sort(charsB);

        return new String(charsA).equals(new String(charsB));
    }
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
