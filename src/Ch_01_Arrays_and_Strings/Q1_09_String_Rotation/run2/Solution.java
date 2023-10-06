package Ch_01_Arrays_and_Strings.Q1_09_String_Rotation.run2;

public class Solution {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }

    private static boolean isRotation(String word1, String word2) {
        if (word1 != null && word2 != null && word1.length() == word2.length() && word1.length() > 0) {
            return (word1 + word1).contains(word2);
        }
        return false;
    }
}
