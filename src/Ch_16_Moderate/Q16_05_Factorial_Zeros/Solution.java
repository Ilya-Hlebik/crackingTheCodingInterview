package Ch_16_Moderate.Q16_05_Factorial_Zeros;

public class Solution {

    public static void main(String[] args) {
        for (int i = 1; i < 16; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }

    public static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }

    public static int countFactZeros(int num) {
        int count = 0;
        for (int i = 5; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

    private static int factorial(int num) {
        if (num == 1) {
            return num;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1;
        }
    }
}
