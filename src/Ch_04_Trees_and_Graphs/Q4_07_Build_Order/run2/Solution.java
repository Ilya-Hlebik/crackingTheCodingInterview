package Ch_04_Trees_and_Graphs.Q4_07_Build_Order.run2;

import java.util.LinkedList;
import java.util.Queue;

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
        String result [] = new String[projects.length];
        Queue<String> tobeResolved = new LinkedList<>();
        for (String project: projects){
            for (int i = 0; i < dependencies.length; i++) {
                if(project.equals(dependencies[i][1])){
                    tobeResolved.add(dependencies[i][0]);
                    i=-1;
                }
            }

        }
        return new String[0];
    }
}
