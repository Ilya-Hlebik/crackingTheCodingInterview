package Ch_01_Arrays_and_Strings.Q1_09_String_Rotation;

public class Solution {

    private static boolean isRotation(String s1, String s2) {
        for (int i = 1; i < s1.length(); i++) {
            String x = s1.substring(i);
            String y = s1.substring(0, i);
            if ((x + y).equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
