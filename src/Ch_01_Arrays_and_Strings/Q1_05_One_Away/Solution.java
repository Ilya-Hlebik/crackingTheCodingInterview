package Ch_01_Arrays_and_Strings.Q1_05_One_Away;

public class Solution {
    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) == 1 || first.length() == second.length()) {
            return checkZeroOrOneAction(first, second);
        }
        return false;
    }

    private static boolean checkZeroOrOneAction(String first, String second) {
        int countOfChanges = 0;
        int index = Math.min(first.length(), second.length());
        boolean firstMoreThanSecond = first.length() > second.length();
        boolean lengthEqual = first.length() == second.length();
        for (int i = 0, j = 0; i < index; i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                countOfChanges++;
                if (!lengthEqual) {
                    if (firstMoreThanSecond) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            if (countOfChanges > 1) {
                return false;
            }
        }
        return true;
    }

/*    public static void main(String[] args) {
        String a = "acbd";
        String b = "abc";
        boolean isOneEdit = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }*/

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
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
}
