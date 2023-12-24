package Ch_16_Moderate.Q16_08_English_Int.run2;

import java.util.LinkedList;

public class Solution {
    public static String[] small = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    public static void main(String[] args) {
        for (int i = -10; i <= 1; i++) {
            String s = convert(i);
            System.out.println(i + ": " + s);
        }
    }

    /*
     * 2 147 999 999
     * two billion one hundred forty seven million nine hundred ninety nine thousand nine hundred ninety nine
     * small big small hundred tens small big small hundred tens small big small hundred tens small
     * */
    private static String convert(int value) {
        if (value == 0) {
            return "zero";
        }
        if (value < 0) {
            return negative + " " + convert(value * -1);
        }
        int bigIndex = 0;
        LinkedList<String> parts = new LinkedList<>();
        while (value > 0) {
            String part = processBellow999(value % 1000).trim() + " " + bigs[bigIndex];
            parts.addFirst(part);
            value /= 1000;
            bigIndex++;
        }
        return String.join(" ", parts);
    }

    private static String processBellow999(int number) {
        if (number < 100) {
            return proceedBellow99(number);
        }
        return small[number / 100] + " " + hundred + " " + proceedBellow99(number % 100);
    }

    private static String proceedBellow99(int number) {
        if (number < 20) {

            return small[number];
        }
        return tens[number / 10] + " " + small[number % 10];
    }
}
