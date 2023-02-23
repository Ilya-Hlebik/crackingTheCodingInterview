package Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;

public class Solution2 {
    public static boolean isPermutationOfPalindrome(String phrase) {
        int from = 'a';
        int to = 'z';
        String phraseLoverCase = phrase.toLowerCase();
        int[] array = new int[to + 1];

        for (int i = 0; i < phraseLoverCase.length(); i++) {
            char character = phraseLoverCase.charAt(i);
            if (from <= character && character <= to) {
                array[character]++;
            }
        }
        boolean notDuplicated = false;
        for (int value : array) {
            if (value % 2 != 0) {
                if (notDuplicated) {
                    return false;
                }
                notDuplicated = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        String pali2 = "Tact Coa";
        String pali3 = "Zeus was deified, saw Suez";
        System.out.println(isPermutationOfPalindrome(pali));
        System.out.println(isPermutationOfPalindrome(pali2));
        System.out.println(isPermutationOfPalindrome(pali3));
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('A'));

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
