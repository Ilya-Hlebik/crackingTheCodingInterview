package Ch_16_Moderate.Q16_09_Operations;

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
            System.out.print(a + " / " + b + " = ");
            int ans = divide(a, b);
            if (ans != a / b) {
                System.out.print("ERROR");
            }
            System.out.println(ans);
        }
    }

    private static int divide(int a, int b) {
        boolean positiveSign = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = abs(a);
        b = abs(b);
        if (b > a || a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return positiveSign ? a : negate(a);
        }
        int product = 0;
        int x = 0;
        while (product + b <= a) { /* don't go past a */
            product += b;
            x++;
        }

        return positiveSign ? x : negate(x);
    }

    private static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        boolean positiveSign = (a > 0 && b > 0) || (a < 0 && b < 0);

        a = abs(a);
        b = abs(b);
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }

        return positiveSign ? sum : negate(sum);
    }

    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        }
        return a;
    }

    private static int minus(int a, int b) {
        return a + negate(b);
    }

    public static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += newSign;
            a += newSign;
        }
        return neg;
    }
}
