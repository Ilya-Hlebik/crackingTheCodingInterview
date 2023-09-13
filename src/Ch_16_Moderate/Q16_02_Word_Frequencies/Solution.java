package Ch_16_Moderate.Q16_02_Word_Frequencies;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(wordlist, word));
        }
    }

    private static int getFrequency(String[] wordlist, String word) {
        int counter = 0;
        word = word.trim();
        for (String wordFromList : wordlist) {
            if (wordFromList.equalsIgnoreCase(word)) {
                counter++;
            }
        }
        return counter;
    }

}
