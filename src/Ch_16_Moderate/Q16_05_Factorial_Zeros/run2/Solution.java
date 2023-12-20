package Ch_16_Moderate.Q16_05_Factorial_Zeros.run2;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i < 25; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }

    private static int countFactZeros(int number) {
        int count = 0;
        for (int i = 5; i <= number; i += 5) {
            int temp = i;
            int tempCount = 0;
            while (temp % 5 == 0) {
                temp /= 5;
                tempCount++;
            }
            count += tempCount;
        }
        return count;
    }

    private static long factorial(int i) {
        if (i < 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
