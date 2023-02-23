package Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {
    public static boolean isPermutationOfPalindrome(String phrase) {
        Pattern compile = Pattern.compile("[a-z]");
        Map<Character, Integer> map = new HashMap<>();
        String phraseLowerCase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            char c = phraseLowerCase.charAt(i);
            if (compile.asPredicate().test(String.valueOf(c))) {
                map.computeIfPresent(c, (character, integer) -> ++integer);
                map.putIfAbsent(c, 1);
            }
        }

        return map.values().stream().allMatch(integer -> integer % 2 == 0) ||
                (map.values().stream().filter(integer -> integer == 1).count() == 1
                        && map.values().stream().filter(integer -> integer != 1).allMatch(integer -> integer % 2 == 0));
    }


    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        String pali2 = "Tact Coa";
        String pali3 = "Zeus was deified, saw Suez";
        System.out.println(isPermutationOfPalindrome(pali));
        System.out.println(isPermutationOfPalindrome(pali2));
        System.out.println(isPermutationOfPalindrome(pali3));
    }

/*    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s : strings) {
            System.out.println(isPermutationOfPalindrome(s));
        }
    }*/
}
