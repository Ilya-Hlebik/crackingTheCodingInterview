package Ch_08_Recursion_and_Dynamic_Programming.Q8_09_Parens;

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

    private static Set<String> generateParens(int count) {
        Set<String> parens = new HashSet<>();
        if (count == 1) {
            parens.add("()");
            return parens;
        }
        Set<String> set = generateParens(count - 1);
        for (String paren : set) {
            for (int i = 0; i < paren.length(); i++) {
                parens.add(new StringBuilder(paren).insert(i, "()").toString());
            }
        }
        return parens;
    }
}
