package Ch_04_Trees_and_Graphs.Q4_07_Build_Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
/*        String[][] dependencies = {
                {"b", "a"},
                {"a", "b"}
        };*/
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

    private static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        List<String> result = new ArrayList<>();
        for (String project : projects) {
            Stack<String> toResolve = new Stack<>();
            if (result.contains(project)) {
                continue;
            }
            for (int i = 0; i < dependencies.length; i++) {
                if (dependencies[i][1].equals(project) && !result.contains(dependencies[i][0])) {
                    toResolve.add(dependencies[i][0]);
                    i = -1;
                    continue;
                }
                if (!toResolve.isEmpty() && toResolve.peek().equals(dependencies[i][1]) && !result.contains(dependencies[i][0])) {
                    toResolve.add(dependencies[i][0]);
                    i = -1;
                }
                if (!toResolve.isEmpty() && toResolve.peek().equals(project)) {
                    return null;
                }
            }
            while (!toResolve.isEmpty()) {
                result.add(toResolve.pop());
            }
            result.add(project);
        }
        return result.toArray(String[]::new);
    }
}
