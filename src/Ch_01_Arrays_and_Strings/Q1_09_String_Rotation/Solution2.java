package Ch_01_Arrays_and_Strings.Q1_09_String_Rotation;

public class Solution2 {
    private static boolean isRotation(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length == s2Length && s1Length > 0) {
            return (s1 + s1).contains(s2);
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
