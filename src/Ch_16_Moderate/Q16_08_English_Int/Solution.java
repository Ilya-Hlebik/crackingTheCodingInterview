package Ch_16_Moderate.Q16_08_English_Int;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        /* numbers between 0 and 100 */
/*        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(0, 100);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }*/

        /* numbers between 100 and 1000 */
        for (int i = 1000; i < 1000000; i++) {
            int value = i;
            String s = convert(value);
            System.out.println(value + ": " + s);
        }
        /*
         *//* numbers between 1000 and 100000 *//*
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(1000, 100000);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }*/
    }

    private static String convert(int value) {
        String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] bigs = {"", "Thousand", "Million", "Billion"};
        String hundred = "Hundred";
        if (value <= 19) {
            return small[value];
        }
        if (value < 100) {
            return processBellow99(value, small, tens);
        } else if (value < 1000) {
            return processBellow999(value, small, tens, hundred);
        } else if (value < 1000000) {
            String last = processBellow999(value % 1000, small, tens, hundred);
            return processBellow999(value / 1000, small, tens, hundred) + " " + bigs[1] + " " + last;
        }
        return "";
    }

    public static String sIfNeeded(int value) {
        if (value > 1) {
            return "s";
        }
        return "";
    }

    private static String processBellow999(int value, String[] small, String[] tens, String hundred) {
        int lastTwo = value % 100;
        int firstNumber = value / 100;
        String hundreds = firstNumber == 0 ? "" : small[firstNumber] + " " + hundred + sIfNeeded(firstNumber);
        return hundreds + " " + processBellow99(lastTwo, small, tens);
    }

    private static String processBellow99(int value, String[] small, String[] tens) {
        if (value <= 19) {
            return value > 0 ? small[value] : "";
        }
        List<Integer> list = new ArrayList<>();
        while (value > 0) {
            int temp = value % 10;
            value = value / 10;
            list.add(temp);
        }
        return tens[list.get(1)] + " " + (list.get(0).equals(0) ? "" : small[list.get(0)]);
    }


}
