package Ch_08_Recursion_and_Dynamic_Programming.Q8_01_Triple_Step;

public class Solution2 {
    public static int countWays(int n) {
        int count1 = 1;
        int count2 = 2;
        int count3 = 4;
        if (n == 1 || n ==0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int memo[] = new int[n + 1];
        memo[0] = count1;
        memo[1] = count2;
        memo[2] = count3;
        for (int i = 3; i < n; i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n-1];
    }

    public static void main(String[] args) {

        for (int i = 1; i < 30; i++) {
            int c1 = countWays(i);
            System.out.println(i + ": " + c1);
        }
    }

}
