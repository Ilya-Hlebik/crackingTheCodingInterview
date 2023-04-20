package Ch_06_Math_and_Logic_Puzzles.Q6_01_The_Heavy_Pill;

public class Solution {

    public static void main(String[] args) {
        /*
         * Need to put all pills in arithmetic progression
         * 1 botl - 1 pil
         * 2 botl - 2 pils
         * ....
         *
         * As result:
         * x = (y -210)/0.1
         * where
         * x - bottle number
         * y - weight
         * */
        int number = getNumber(211.3);
        System.out.println(number);
    }

    public static int getNumber(double weight) {
        return (int) ((weight - 210) / 0.1);
    }
}
