package Ch_08_Recursion_and_Dynamic_Programming.Q8_05_Recursive_Multiply;

public class Solution {
    public static void main(String[] args) {
        int a = 13494;
        int b = 22323;
        int product = a * b;
        int minProduct = minProduct(a, b);
        if (product == minProduct) {
            System.out.println("Success: " + a + " * " + b + " = " + product);
        } else {
            System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
        }
    }

    private static int minProduct(int a, int b) {
        int aCount = 0;
        boolean needAddB = false;
        boolean needAddB2 = false;
        if (a % 2 == 0) {
            while (a % 2 == 0) {
                a = a / 2;
                aCount++;
            }
        } else {
            a += 1;
            aCount--;
            while (a % 2 == 0) {
                a = a / 2;
                aCount++;
            }

            needAddB = true;
        }
        if (b % 2 == 0) {
            while (b % 2 == 0) {
                b = b / 2;
                aCount++;
            }
        }
        else {
            b += 1;
            aCount--;
            while (b % 2 == 0) {
                b = b / 2;
                aCount++;
            }

            needAddB2 = true;
        }
        int sum = sum(a, b);
        for (int i = 0; i < aCount; i++) {
            sum += sum;
        }
        if (needAddB) {
            sum += b;
        }
        if (needAddB2) {
            sum += b;
        }
        return sum;
    }

    private static int sum(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + sum(a, b - 1);
    }
}
