package Ch_06_Math_and_Logic_Puzzles.Q6_02_Basketball.run2;

public class Solution {
    public static void main(String[] args) {
        /*
         * Probability of first option - p
         *
         * P(second) = (hit * hit * mis) + (hit * mis * hit) + (mis * hit * hit)
         * = p^2*(1-p) + p^2*(1-p) + p^2*(1-p)
         * = p^2 - p^3 + p^2 - p^3 + p^2 - p^3
         * = 3p^2 -3p^3
         * all 3
         * = p^3 + 3p^2 - 3p^3
         * = 3p^2 - 2p^3
         *
         *
         * Which Play?
         * if P(game 1) > P(Game 2)
         * p > 3p^2 - 2p^3
         * move to left + divide by p
         * 2p^2 - 3p +1 > 0
         * (2p -1)(p-1) >0
         * both must be negative
         * so
         * p<1/2
         *
         * Game 1 if 0< p <1/2 Game 2 if 1/2 < p < 1
         * */
    }
}
