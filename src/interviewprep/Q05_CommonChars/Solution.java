package interviewprep.Q05_CommonChars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }

    public static List<String> commonChars(String[] words) {
        List<String> chars = words[0].chars().mapToObj(i1 -> String.valueOf((char) i1)).collect(Collectors.toList());
        List<String> toRemove = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            for (String aChar : chars) {
                if (!word.contains(aChar)) {
                    toRemove.add(aChar);
                }
                if (word.contains(aChar)) {
                    word = word.replaceFirst(aChar, "");
                }
            }
            toRemove.forEach(chars::remove);
            toRemove.clear();
            if (chars.isEmpty()) {
                return Collections.emptyList();
            }
        }
        return chars;
    }
}
