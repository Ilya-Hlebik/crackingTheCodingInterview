package interviewprep.Q01_PalindromeAfterRemoveCharacter;

/**
 * Given a string, check whether it will become a palindrome after removing exactly one character from it
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("abc"));
    }

   public static boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char[] newChars = new char[s.length()-1];
            for (int j = 0, k= 0; j < chars.length; j++) {
                if(j != i){
                    newChars[k] = chars[j];
                    k++;
                }
            }
            String str = new String(newChars);
            if (str.equals(new StringBuilder(str).reverse().toString())){
                return true;
            }
        }
        return false;
    }
}
