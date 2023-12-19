package Ch_16_Moderate.Q16_02_Word_Frequencies.run2;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
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
        return dictionary.getOrDefault(word.toLowerCase(), 0);
    }

    private static Map<String, Integer> setupDictionary(String[] wordlist) {
        return Arrays.stream(wordlist)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word))
                .entrySet()
                .stream()
                .map(stringListEntry -> Map.entry(stringListEntry.getKey(), stringListEntry.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
