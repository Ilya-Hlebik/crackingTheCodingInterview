package Ch_01_Arrays_and_Strings.Q1_01_Is_Unique;

public class Solution2 {

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_array = new boolean[128];
        for (int i = 0; i < str.toCharArray().length; i++) {
            char val = str.charAt(i);
            if (char_array[val]) {
                return false;
            }
            char_array[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
