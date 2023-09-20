package Ch_16_Moderate.Q16_08_English_Int;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        /* numbers between 100000 and 1000000 */
        for (int i = 0; i < 8; i++) {
            int value = (int) (-1 * Math.pow(10, i));
            String s = convert(value);
            System.out.println(value + ": " + s);
        }

        /* numbers between 0 and 100 */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(0, 100);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }

        /* numbers between 100 and 1000 */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(100, 1000);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }

        /* numbers between 1000 and 100000 */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(1000, 100000);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }


        /* numbers between 100000 and 100000000 */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(100000, 100000000);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }

        /* numbers between 100000000 and 1000000000 */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(100000000, 1000000000);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }

        /* numbers between 1000000000 and Integer.MAX_VALUE */
        for (int i = 0; i < 10; i++) {
            int value = AssortedMethods.randomIntInRange(1000000000, Integer.MAX_VALUE);
            String s = convert(value);
            System.out.println(value + ": " + s);
        }
    }

    public static String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    private static String convert(int value) {
        if (value == 0) {
            return small[0];
        } else if (value < 0) {
            return negative + " " + convert(-1 * value);
        }
        List<String> result = new ArrayList<>();
        int devidible = 1000;
        int index = 0;
        while (value > 0) {
            int finalIndex = index;
            if (value % 1000 != 0) {
                String text = Optional.of(processBellow999(value % 1000).trim()).filter(s -> !s.isEmpty()).map(s -> " " + s + " " + bigs[finalIndex] + " ").orElse("");
                if (!text.trim().isEmpty()) {
                    result.add(text);
                }
            }
            value /= devidible;
            index++;
        }
        StringBuilder finalRes = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            finalRes.append(result.get(i));
        }
        return finalRes.toString();
    }


    private static String processBellow999(int value) {
        int lastTwo = value % 100;
        int firstNumber = value / 100;
        String hundreds = firstNumber == 0 ? "" : small[firstNumber] + " " + hundred;
        return hundreds + " " + processBellow99(lastTwo);
    }

    private static String processBellow99(int value) {
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
