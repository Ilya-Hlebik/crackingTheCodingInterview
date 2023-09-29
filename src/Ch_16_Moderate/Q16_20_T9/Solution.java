package Ch_16_Moderate.Q16_20_T9;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    static Map<String, ArrayList<String>> combinations = null;
    public static char[][] t9Letters = {
            null,                    // 0
            null,                    // 1
            {'a', 'b', 'c'},        // 2
            {'d', 'e', 'f'},        // 3
            {'g', 'h', 'i'},        // 4
            {'j', 'k', 'l'},        // 5
            {'m', 'n', 'o'},        // 6
            {'p', 'q', 'r', 's'},    // 7
            {'t', 'u', 'v'},        // 8
            {'w', 'x', 'y', 'z'}    // 9
    };

    public static void main(String[] args) {
        ArrayList<String> words = getValidT9Words("33835676368", AssortedMethods.getWordListAsHashSet());
        for (String w : words) {
            System.out.println(w);
        }
    }

    private static ArrayList<String> getValidT9Words(String number, HashSet<String> wordListAsHashSet) {
        Map<String, ArrayList<String>> combinationsByDictionary = getCombinationsByDictionary(wordListAsHashSet);
        return combinationsByDictionary.getOrDefault(number, new ArrayList<>());
    }

    public static Map<String, ArrayList<String>> getCombinationsByDictionary(HashSet<String> wordListAsHashSet) {
        if (combinations != null) {
            return combinations;
        }
        combinations = new HashMap<>();

        for (String word : wordListAsHashSet) {
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                for (int r = 2; r < t9Letters.length; r++) {
                    for (int j = 0; j < t9Letters[r].length; j++) {
                        if (String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(t9Letters[r][j]))) {
                            number.append(r);
                            break;
                        }
                    }
                }
            }
            ArrayList<String> words = combinations.getOrDefault(number.toString(), new ArrayList<>());
            words.add(word);
            combinations.put(number.toString(), words);
        }


        return combinations;
    }
}
