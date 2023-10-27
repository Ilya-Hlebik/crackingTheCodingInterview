package Ch_08_Recursion_and_Dynamic_Programming.Q8_11_Coins.run2;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 201; i++) {
            int[] denoms = {25, 10, 5, 1};
            int waysA = makeChange(i, denoms);
            System.out.println(i + " " +waysA);
        }

    }

    private static int makeChange(int i, int[] denoms) {
        if (i == 0){
            return 1;
        }
        if (i <0){
            return 0;
        }
        return makeChange(i-denoms[0], denoms) +   makeChange(i-denoms[1], denoms) +  makeChange(i-denoms[2], denoms) + makeChange(i-denoms[3], denoms);
    }
}
