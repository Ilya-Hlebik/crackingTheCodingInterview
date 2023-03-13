package interviewprep.Q08_RomanToInteger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int romanToInt(String s) {
        Map<String, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);

        Map<String, Integer> substractionMap = new HashMap<>();
        substractionMap.put("IV", 4);
        substractionMap.put("IX", 9);
        substractionMap.put("XL", 40);
        substractionMap.put("XC", 90);
        substractionMap.put("CD", 400);
        substractionMap.put("CM", 900);

        for (Map.Entry<String, Integer> entry : substractionMap.entrySet()) {
            String s1 = entry.getKey();
            Integer integer = entry.getValue();
            if (s.contains(s1)){
                s = s.replaceAll(s1, " " + integer);
            }
        }
        for (Map.Entry<String, Integer> entry : romanToIntMap.entrySet()) {
            String s1 = entry.getKey();
            Integer integer = entry.getValue();
            if (s.contains(s1)){
                s = s.replaceAll(s1, " " + integer);
            }
        }
        return Arrays.stream(s.trim().split(" ")).map(Integer::parseInt).mapToInt(value -> value).sum();
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
