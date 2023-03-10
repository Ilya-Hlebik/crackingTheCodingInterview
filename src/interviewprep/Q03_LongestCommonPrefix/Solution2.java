package interviewprep.Q03_LongestCommonPrefix;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(longestPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestPrefix(String[] strs) {
        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while ( strs[i].indexOf(longestPrefix) !=0) {
                longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
                if (longestPrefix.isEmpty()) {
                    return "";
                }
            }
        }
        return longestPrefix;
    }
}
