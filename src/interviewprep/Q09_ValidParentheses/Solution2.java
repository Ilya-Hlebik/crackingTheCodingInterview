package interviewprep.Q09_ValidParentheses;

public class Solution2 {
    public static boolean isValid(String s) {
        int sLength = Integer.MAX_VALUE;
        while (sLength > s.length()) {
            sLength = s.length();
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
