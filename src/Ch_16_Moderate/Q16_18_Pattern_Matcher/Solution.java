package Ch_16_Moderate.Q16_18_Pattern_Matcher;

public class Solution {
    public static void main(String[] args) {
        String[][] tests = {{"ababb", "backbatbackbatbat"}, {"abab", "backsbatbackbats"}, {"aba", "backsbatbacksbat"}};
        for (String[] test : tests) {
            String pattern = test[0];
            String value = test[1];
            System.out.println(pattern + ", " + value + ": " + doesMatch(pattern, value));
        }
    }

    private static boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        for (int i = 0; i < value.length(); i++) {
            String substringA = value.substring(0, i);
            for (int j = i; j <= value.length(); j++) {
                String substringB = value.substring(i, j);
                String candidate;
                if (pattern.startsWith("a")) {
                    candidate = buildCandidate(pattern, substringA, substringB);
                } else {
                    candidate = buildCandidate(pattern, substringB, substringA);
                }

                if (candidate.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String buildCandidate(String pattern, String substringA, String substringB) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                result.append(substringA);
            } else {
                result.append(substringB);
            }
        }
        return result.toString();
    }
}
