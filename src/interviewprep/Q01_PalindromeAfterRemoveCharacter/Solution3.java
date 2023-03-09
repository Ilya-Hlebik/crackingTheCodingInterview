package interviewprep.Q01_PalindromeAfterRemoveCharacter;

/**
 * Given a string, check whether it will become a palindrome after removing exactly one character from it
 */
public class Solution3 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("abc"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder fastCheckBuilder = new StringBuilder(s);
        if (fastCheckBuilder.toString().equals(fastCheckBuilder.reverse().toString())) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.deleteCharAt(i);
            if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
                return true;
            }
        }
        return false;
    }
}
