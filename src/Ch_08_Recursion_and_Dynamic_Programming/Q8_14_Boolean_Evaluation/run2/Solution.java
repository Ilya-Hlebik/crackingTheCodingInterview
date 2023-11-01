package Ch_08_Recursion_and_Dynamic_Programming.Q8_14_Boolean_Evaluation.run2;

public class Solution {
    public static int count = 0;

    public static void main(String[] args) {
        String terms = "0^0|1&1^1|0|1";
        boolean result = true;
        int a = countEval(terms, result);
        System.out.println(a);
        System.out.println(count);
    }

    private static int countEval(String terms, boolean result) {
        if (terms.length() == 0) {
            return 0;
        }
        if (terms.length() == 1) {
            return (terms.equals("1")) == result ? 1 : 0;
        }

        int ways = 0;
        for (int i = 1; i < terms.length(); i += 2) {
            char c = terms.charAt(i);
            String left = terms.substring(0, i);
            String right = terms.substring(i + 1);
            int leftTrue = countEval(left, true);
            int rightTrue = countEval(right, true);
            int leftFalse = countEval(left, false);
            int rightFalse = countEval(right, false);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * leftFalse;
            }
            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        return ways;
    }
}
