package Ch_16_Moderate.Q16_26_Calculator;

public class Solution {
    public static void main(String[] args) {
        //3.6+10-2+3+3
        String expression = "6/5*3+4*5/2-12/6*3/3+3+3";
        double result = compute(expression);
        System.out.println(result);
    }

    private static double compute(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            if (!expression.contains("/") && !expression.contains("*")){
                break;
            }
            char operation = expression.charAt(i);
            if (operation == '/' || operation == '*') {
                expression = computeValueInExpression(expression, i, operation);
                i = -1;
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            if (!expression.contains("+") && !expression.contains("-")) {
                break;
            }
            char operation = expression.charAt(i);
            if (operation == '+' || operation == '-') {
                expression = computeValueInExpression(expression, i, operation);
                i = -1;
            }
        }

        return Double.parseDouble(expression);
    }

    private static String computeValueInExpression(String expression, int i, char operation) {
        StringBuilder leftArg = getLeftArg(expression, i);
        StringBuilder rightArg = getRightArg(expression, i);
        String left = leftArg.reverse().toString();
        String value = left + operation + rightArg.toString();
        Double result = computeResult(operation, left, rightArg.toString());
        expression = expression.replace(value, String.valueOf(result));
        return expression;
    }

    private static StringBuilder getRightArg(String expression, int i) {
        StringBuilder rightArg = new StringBuilder();
        for (int j = i + 1; j < expression.length(); j++) {
            char c1 = expression.charAt(j);
            if (c1 != '/' && c1 != '*' && c1 != '+' && c1 != '-') {
                rightArg.append(c1);
            } else {
                break;
            }
        }
        return rightArg;
    }

    private static StringBuilder getLeftArg(String expression, int i) {
        StringBuilder leftArg = new StringBuilder();
        for (int j = i - 1; j>=0; j--) {
            char c1 = expression.charAt(j);
            if (c1 != '/' && c1 != '*' && c1 != '+' && c1 != '-') {
                leftArg.append(c1);
            } else {
                break;
            }
        }
        return leftArg;
    }

    private static Double computeResult(char operation, String left, String right) {
        if (operation == '*') {
            return Double.parseDouble(left) * Double.parseDouble(right);
        }
        if (operation == '/') {
            return Double.parseDouble(left) / Double.parseDouble(right);
        }
        if (operation == '+') {
            return Double.parseDouble(left) + Double.parseDouble(right);
        }
        if (operation == '-') {
            return Double.parseDouble(left) - Double.parseDouble(right);
        } else {
            throw new RuntimeException();
        }
    }
}
