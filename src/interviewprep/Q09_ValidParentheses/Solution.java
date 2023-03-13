package interviewprep.Q09_ValidParentheses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s.length()%2 != 0){
            return false;
        }
        Map<String,String> parentheses = new HashMap<>();
        parentheses.put("(",")");
        parentheses.put("{","}");
        parentheses.put("[","]");
        List<String> openParentheses = List.of("(", "{","[");
        Stack<String> stack = new Stack<>();
        for (String s1 : s.split("")) {
            if (openParentheses.contains(s1)){
                stack.push(s1);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();
                String s2 = parentheses.get(pop);
                if (!s2.equals(s1)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
}
