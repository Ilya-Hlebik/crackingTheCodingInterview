package Ch_04_Trees_and_Graphs.Q4_07_Build_Order.run2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"h", "a"},
                {"h", "g"},
                {"g", "a"},
                {"a", "b"},
                {"b", "c"},
                {"h", "b"},
                {"g", "b"},
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
        String[] result = new String[projects.length];
        int index = 0;
        Stack<String> tobeResolved = new Stack<>();
        Set<String> resolvedProjects = new HashSet<>();
        for (String project : projects) {
            if (resolvedProjects.contains(project)) {
                continue;
            }
            tobeResolved.add(project);
            while (!tobeResolved.isEmpty()) {
                String peek = tobeResolved.peek();
                if (resolvedProjects.contains(peek)) {
                    tobeResolved.pop();
                    continue;
                }
                boolean wasResolved = true;
                for (String[] dependency : dependencies) {
                    if (peek.equals(dependency[1]) && !resolvedProjects.contains(dependency[0])) {
                        wasResolved = false;
                        tobeResolved.add(dependency[0]);
                    }
                }
                if (wasResolved) {
                    resolvedProjects.add(peek);
                    result[index++] = tobeResolved.pop();
                }
            }
        }
        return result;
    }
}
