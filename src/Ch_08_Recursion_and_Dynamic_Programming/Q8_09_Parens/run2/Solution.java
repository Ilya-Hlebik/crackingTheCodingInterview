package Ch_08_Recursion_and_Dynamic_Programming.Q8_09_Parens.run2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> list = generateParens(5);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }

    private static Set<String> generateParens(int index) {
        Set<String> result = new HashSet<>();
        if (index == 1){
            result.add("()");
            return result;
        }
        Set<String> set = generateParens(index-1);
        for (String s : set) {
            for (int i = 0; i < s.length(); i++) {
                String newRes = new StringBuilder(s).insert(i, "()").toString();
                result.add(newRes);
            }
        }

        return result;
    }
}
