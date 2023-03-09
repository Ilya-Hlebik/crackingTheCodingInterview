package interviewprep.Q01_PalindromeAfterRemoveCharacter;

/**
 * Given a string, check whether it will become a palindrome after removing exactly one character from it
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("abc"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean validPalindrome (String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
