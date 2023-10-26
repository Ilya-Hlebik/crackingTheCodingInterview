package Ch_08_Recursion_and_Dynamic_Programming.Q8_05_Recursive_Multiply.run2;

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
        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0){
            return 0;
        }
        if (smaller == 1){
            return bigger;
        }
        int half = smaller >>1;
        int side1 = minProductHelper(half, bigger);
        int side2 = side1;
        if (smaller %2 ==1){
            side2 = minProductHelper(smaller-half, bigger);
        }
        return side1 + side2;
    }
}
