package interviewprep.Q07_IsPalindrome;

public class Solution {
    public static boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
