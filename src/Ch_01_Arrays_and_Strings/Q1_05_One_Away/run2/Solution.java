package Ch_01_Arrays_and_Strings.Q1_05_One_Away.run2;

public class Solution {

    public static void main(String[] args) {
        String[][] tests = {
                {"acdsfdsfadsq", "acdsfdfadsf", "false"}
               };
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            test(a, b, expected);
            test(b, a, expected);
        }

    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = oneEditAway(a, b);
        System.out.println("a:" + a + " b:" + b + " " + resultA + " " + expected);
    }

    private static boolean oneEditAway(String a, String b) {
        if (a == null || b == null || a.length() - b.length() > 1) {
            return false;
        }
        boolean differentSizes = a.length() != b.length();
        int countOfDiffs = 0;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j)) {
                if (differentSizes) {
                    if (a.length() > b.length()) {
                        j--;
                    } else {
                        i--;
                    }
                }
                countOfDiffs++;
                if (countOfDiffs > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
