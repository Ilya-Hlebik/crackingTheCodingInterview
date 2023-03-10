package interviewprep.Q02_ArmstrongNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args) {
        List<Integer> armstrongNumbers = armstrongNumberInFixedRange();
        System.out.println(armstrongNumbers);
    }

    private static List<Integer> armstrongNumberInFixedRange() {
        //0-999
        //if  left side == right side -> success
        return IntStream.range(0, 1000)
                .filter(i -> calculateResultSum(i) == i)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int calculateResultSum(int i) {
        int resultSum = 0;
        int length = Integer.toString(i).length();
        while (i != 0) {
            resultSum += Math.pow(i % 10, length);
            i /= 10;
        }
        return resultSum;
    }
}
