package Ch_01_Arrays_and_Strings.Q1_01_Is_Unique;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static boolean isUniqueChars(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.get(c) != null){
                return false;
            }
            map.put(c, 1);
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
