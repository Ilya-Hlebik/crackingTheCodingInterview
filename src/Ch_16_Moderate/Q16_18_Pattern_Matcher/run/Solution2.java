package Ch_16_Moderate.Q16_18_Pattern_Matcher.run;

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

        int size = value.length();
        char mainChar = pattern.charAt(0);
        int altChar = mainChar == 'a' ? 'b' : 'a';
        int countOfMain = getCountOfMain(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);


        for (int mainSize = 0; mainSize < size / countOfMain; mainSize++) {

            String main = value.substring(0, mainSize);
            int altSizeFull = (size - (mainSize * countOfMain));
            if (countOfAlt == 0 || altSizeFull % countOfAlt == 0) {
                String alt = value.substring(mainSize, (mainSize) + (altSizeFull / countOfAlt));
                String candidate = buildPattern(pattern, main, alt);
                if (candidate.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getCountOfMain(String pattern, char mainChar) {
        int count = 0;
        for (char c : pattern.toCharArray()) {
            if (c == mainChar) {
                count++;
            }
        }
        return count;
    }

    private static String buildPattern(String pattern, String main, String alt) {
        char mainChar = pattern.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            if (c == mainChar) {
                stringBuilder.append(main);
            } else {
                stringBuilder.append(alt);
            }
        }

        return stringBuilder.toString();
    }


}
