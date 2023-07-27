package Ch_08_Recursion_and_Dynamic_Programming.Q8_11_Coins;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 201; i++) {
            int[] denoms = {25, 10, 5, 1};
            int waysA = makeChange(i, denoms);
            System.out.println(i + " " +waysA);
        }

    }

    private static int makeChange(int i, int[] denoms) {
        int[] memo = new int[i + 1];
        int i1 = makeChange(i, denoms, 0);
        return i1;
    }

    private static int makeChange(int total, int[] denoms, int index) {
        int coin = denoms[index];
        if (index == denoms.length - 1) {
            return total % coin == 0 ? 1 : 0;
        }

        int ways = 0;
        for (int amount = 0; amount <= total; amount += coin) {
            ways += makeChange(total - amount, denoms, index + 1);
        }

        return ways;
    }
}
