package Ch_16_Moderate.Q16_09_Operations.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int minRange = -100;
        int maxRange = 100;
        int cycles = 100;

        for (int i = 0; i < cycles; i++) {
            int a = AssortedMethods.randomIntInRange(minRange, maxRange);
            int b = AssortedMethods.randomIntInRange(minRange, maxRange);
            int ans = minus(a, b);
            if (ans != a - b) {
                System.out.println("ERROR");
            }
            System.out.println(a + " - " + b + " = " + ans);
        }
        for (int i = 0; i < cycles; i++) {
            int a = AssortedMethods.randomIntInRange(minRange, maxRange);
            int b = AssortedMethods.randomIntInRange(minRange, maxRange);
            int ans = multiply(a, b);
            if (ans != a * b) {
                System.out.println("ERROR " + a * b);
            }
            System.out.println(a + " * " + b + " = " + ans);
        }
        for (int i = 0; i < cycles; i++) {
            int a = AssortedMethods.randomIntInRange(minRange, maxRange);
            int b = AssortedMethods.randomIntInRange(minRange, maxRange);
            int ans = divide(a, b);
            if (ans != a / b) {
                System.out.println("ERROR " + a / b);
            }
            System.out.println(a + " / " + b + " = " + ans);
        }
    }

    private static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int temp = 0;
        int i = 0;
        while (temp <= abs(a)) {
            i++;
            temp = multiply(abs(b), i);
        }
        return i == 0 ? 0 : processSign(minus(i, 1), a, b);
    }

    private static int processSign(int i, int a, int b) {
        if (a > 0 && b > 0) {
            return i;
        } else if (a > 0 || b > 0) {
            return ~i + 1;
        }
        return i;
    }

    private static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int tempA = a > 0 ? a : ~a + 1;
        int tempB = b > 0 ? b : ~b + 1;
        while (tempB > 1) {
            tempA += abs(a);
            tempB = minus(tempB, 1);
        }
        return processSign(tempA, a, b);
    }

    private static int abs(int value) {
        if (value < 0) {
            return ~value + 1;
        }
        return value;
    }

    private static int minus(int a, int b) {
        return a + (~b) + 1;
    }
}
