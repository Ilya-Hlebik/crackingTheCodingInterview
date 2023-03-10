package interviewprep.Q04_IsAnagrams;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        return s.length() == t.length() && isEquals(s, t);
    }

    private boolean isEquals(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, t.toCharArray());
    }

    public static void main(String[] args) {

    }
}
