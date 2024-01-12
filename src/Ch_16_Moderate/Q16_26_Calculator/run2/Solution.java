package Ch_16_Moderate.Q16_26_Calculator.run2;

public class Solution {
    public static void main(String[] args) {
        //3.6+10-2+3+3
        String expression = "64/52*3+4*5/2-12/6*3/3+3+3";
        double result = compute(expression);
        System.out.println(result);
    }

    private static double compute(String expression) {
        expression = compute(expression, '*', '/');
        expression = compute(expression, '+', '-');
        return Double.parseDouble(expression);
    }

    private static String compute(String expression, char operandOne, char operandTwo) {
        for (int i = 1; i < expression.length(); i++) {
            char operation = expression.charAt(i);
            if (operation == operandOne || operation == operandTwo) {
                String leftOperand = "";
                for (int j = i - 1; j >= 0; j--) {
                    if ((!Character.isDigit(expression.charAt(j)) && expression.charAt(j) != '.') || j == 0) {
                        leftOperand = expression.substring(j == 0 ? 0 : j + 1, i);
                        break;
                    }
                }
                String rightOperand = "";
                for (int j = i + 1; j < expression.length(); j++) {
                    if ((!Character.isDigit(expression.charAt(j)) && expression.charAt(j) != '.') || j == expression.length() - 1) {
                        rightOperand = expression.substring(i + 1, j == expression.length() - 1 ? j + 1 : j);
                        break;
                    }
                }
                String wholeOperation = leftOperand + operation + rightOperand;
                double result = calculateOperation(leftOperand, rightOperand, operation);
                String resultAsString = String.valueOf(result);
                expression = expression.replace(wholeOperation, resultAsString);
                i = i - 1;
            }
        }
        return expression;
    }

    private static double calculateOperation(String leftOperand, String rightOperand, char operation) {
        switch (operation) {
            case '/':
                return Double.parseDouble(leftOperand) / Double.parseDouble(rightOperand);
            case '*':
                return Double.parseDouble(leftOperand) * Double.parseDouble(rightOperand);
            case '-':
                return Double.parseDouble(leftOperand) - Double.parseDouble(rightOperand);
            default:
                return Double.parseDouble(leftOperand) + Double.parseDouble(rightOperand);
        }
    }
}
