package Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation.run2;

public class Solution {
    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        String pali2 = "Tact Coa";
        String pali3 = "Zeus was deified, saw Suez";
        System.out.println(isPermutationOfPalindrome(pali));
        System.out.println(isPermutationOfPalindrome(pali2));
        System.out.println(isPermutationOfPalindrome(pali3));
    }

    private static boolean isPermutationOfPalindrome(String pali) {
        boolean[] chars = new boolean[128];
        char[] paliCharArray = pali.toLowerCase().toCharArray();
        for (char aChar : paliCharArray) {
            if (Character.isAlphabetic(aChar)) {
                chars[aChar] = !chars[aChar];
            }
        }
       int countOfTrue = 0;
        for (boolean aChar : chars) {
            if (aChar){
                countOfTrue++;
            }
            if (countOfTrue > 1){
                return false;
            }
        }
        return true;
    }
}
