package interviewprep.Q02_ArmstrongNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * A positive integer is called an Armstrong number of order n if
 * abcd... = a^n + b^n + c^n + d^n + ...
 * In the case of an Armstrong number of 3 digits, the sum of cubes of each digits is equal to the number itself. For example:
 * 153 = 1*1*1 + 5*5*5 + 3*3*3
 * <p>
 * For range from 0 to 999 return all the numbers that are Armstrong numbers.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(allArmstrongNumbersInRange());
    }

    public static List<Integer> allArmstrongNumbersInRange() {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int n = Integer.toString(i).length();
            int tmp = i;
            int resultSum = 0;
            while (tmp > 0) {
                resultSum += Math.pow(tmp % 10, n);
                tmp /= 10;
            }
            if (resultSum == i) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
