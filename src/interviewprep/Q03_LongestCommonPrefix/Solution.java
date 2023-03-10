package interviewprep.Q03_LongestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPrefix(new String[]{"flower","flower","flower","flower"}));
    }

    public static String longestPrefix(String[] strs) {
        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String substring = "";
            for (int j = 0; j < longestPrefix.toCharArray().length; j++) {
                String temp = longestPrefix.substring(0, j+1);
                if (!strs[i].startsWith(temp)) {
                    break;
                }
                substring = temp;
            }
            if (substring.equals("")) {
                return "";
            }
            longestPrefix = substring;
        }
        return longestPrefix;
    }
}
