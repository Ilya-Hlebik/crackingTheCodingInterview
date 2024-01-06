package Ch_16_Moderate.Q16_20_T9.run2;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> words = getValidT9Words("33835676368", AssortedMethods.getWordListAsHashSet());
        for (String w : words) {
            System.out.println(w);
        }
    }

    static Map<String, ArrayList<String>> dictionary = null;
    public static String[] t9Letters = {
            null,                    // 0
            null,                    // 1
            "abc",        // 2
            "def",        // 3
            "ghi",        // 4
            "jkl",        // 5
            "mno",        // 6
            "pqrs",    // 7
            "tuv",        // 8
            "wxyz"    // 9
    };

    private static ArrayList<String> getValidT9Words(String s, HashSet<String> wordListAsHashSet) {
        if (dictionary == null) {
            dictionary = new HashMap<>();
            for (String word : wordListAsHashSet) {
                StringBuilder number = new StringBuilder();
                for (char c : word.toCharArray()) {
                    for (int i = 2; i < t9Letters.length; i++) {
                        if (t9Letters[i].contains(String.valueOf(c))) {
                            number.append(i);
                        }
                    }
                }
                ArrayList<String> orDefault = dictionary.getOrDefault(number.toString(), new ArrayList<>());
                orDefault.add(word);
                dictionary.put(number.toString(), orDefault);
            }
        }
        return dictionary.get(s);
    }
}
