package Ch_16_Moderate.Q16_02_Word_Frequencies;

import CtCILibrary.AssortedMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution2 {

    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        Map<String, Integer> dictionary = setupDictionary(wordlist);

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(dictionary, word));
        }
    }

    private static int getFrequency(Map<String, Integer> dictionary, String word) {
        if (dictionary == null || word == null) {
            return -1;
        }
        return Optional.ofNullable(dictionary.get(word.toLowerCase())).orElse(0);
    }

    private static Map<String, Integer> setupDictionary(String[] wordlist) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : wordlist) {
            word = word.trim().toLowerCase();
            Integer currentCount = dictionary.get(word);
            dictionary.put(word, currentCount != null ? ++currentCount : 1);
        }
        return dictionary;
    }
}
