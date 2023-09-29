package Ch_16_Moderate.Q16_20_T9;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution2 {
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

    private static ArrayList<String> getValidT9Words(String phoneNumber, HashSet<String> wordListAsHashSet) {
        ArrayList<String> response = new ArrayList<>();
        getValidT9Words(phoneNumber, 0, "", wordListAsHashSet, response);
        return response;
    }

    private static void getValidT9Words(String number, int index, String prefix, HashSet<String> wordListAsHashSet, ArrayList<String> response) {
        if (index >= number.length()) {
            if (wordListAsHashSet.contains(prefix)) {
                response.add(prefix);
            }
            return;
        }
        char c1 = number.charAt(index);
        char[] t9Letter = t9Letters[Integer.parseInt(String.valueOf(c1))];
        if (t9Letter != null)
            for (char c : t9Letter) {
                getValidT9Words(number, index + 1, prefix + c, wordListAsHashSet, response);
            }
    }
}
