package Ch_16_Moderate.Q16_01_Number_Swapper.run2;

public class Solution {
    public static void main(String[] args) {
        int a = 1672;
        int b = 9332;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        swap(a, b);
    }

    private static void swap(int a, int b) {
        a += b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
