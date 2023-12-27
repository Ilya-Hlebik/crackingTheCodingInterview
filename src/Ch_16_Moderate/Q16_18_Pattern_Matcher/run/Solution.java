package Ch_16_Moderate.Q16_18_Pattern_Matcher.run;

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
        for (int mainSize = 0; mainSize < value.length(); mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= value.length(); altStart++) {
                for (int altEnd = altStart; altEnd <= value.length(); altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String candidate = buildPattern(pattern, main, alt);
                    if (candidate.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String buildPattern(String pattern, String main, String alt) {
        char mainChar = pattern.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            if (c == mainChar){
                stringBuilder.append(main);
            }
            else {
                stringBuilder.append(alt);
            }
        }

        return stringBuilder.toString();
    }


}
