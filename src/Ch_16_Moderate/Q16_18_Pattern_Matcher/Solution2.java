package Ch_16_Moderate.Q16_18_Pattern_Matcher;

public class Solution2 {
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
        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';
        int size = value.length();

        int countOfMain = count(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            String first = value.substring(0, mainSize);
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                String second = countOfAlt == 0 ? "" : value.substring(altIndex, altIndex + altSize);
                String candidate = buildCandidate(pattern, first, second);
                if (candidate.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    private static int count(String pattern, char mainChar) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == mainChar) {
                count++;
            }
        }
        return count;
    }

    private static String buildCandidate(String pattern, String main, String alt) {
        StringBuilder result = new StringBuilder();
        char first = pattern.charAt(0);
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == first) {
                result.append(main);
            } else {
                result.append(alt);
            }
        }
        return result.toString();
    }
}
