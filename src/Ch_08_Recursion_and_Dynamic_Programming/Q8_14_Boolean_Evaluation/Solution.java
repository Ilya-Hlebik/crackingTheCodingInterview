package Ch_08_Recursion_and_Dynamic_Programming.Q8_14_Boolean_Evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static boolean allEqual(HashMap<String, Integer> map) {
        int val = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (val != 0 && val != e.getValue()) {
                return false;
            }
            val = e.getValue();
        }
        return true;
    }

    public static char getRandomOperator() {
        Random rand = new Random();
        int r = rand.nextInt(3);
        char[] ops = {'^', '&', '|'};
        return ops[r];
    }

    public static String getRandomExpression() {
        Random rand = new Random();
        int len = rand.nextInt(10) * 2 + 1;
        String s = "";
        for (int i = 0; i < len; i++) {
            char next = '1';
            if (i % 2 == 0) {
                next = rand.nextBoolean() ? '1' : '0';
            } else {
                next = getRandomOperator();
            }
            s += next;
        }
        return s;
    }

    public static void main(String[] args) {
        String terms = "0^0|1&1^1|0|1";
        boolean result = true;
        int a = countEval(terms, result);
        System.out.println(a);
        System.out.println(count);
    }

    public static int count = 0;

    private static int countEval(String terms, boolean result) {
        count++;
        if (terms.length() == 0) return 0;
        if (terms.length() == 1) {
            return stringToBool(terms) == result ? 1 : 0;
        }
        int ways = 0;
        for (int i = 1; i < terms.length(); i += 2) {
            char c = terms.charAt(i);
            String left = terms.substring(0, i);
            String right = terms.substring(i + 1);
            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
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
            int subways = result ? totalTrue : total - totalTrue;
            ways += subways;
        }
        return ways;
    }

    public static boolean stringToBool(String c) {
        return c.equals("1");
    }
}

