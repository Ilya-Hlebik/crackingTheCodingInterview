package Ch_04_Trees_and_Graphs.Q4_07_Build_Order;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {
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
        Project[] buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) {
            return null;
        }
        String[] buildOrderString = convertToStringList(buildOrder);
        return buildOrderString;
    }

    private static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);
        for (int i = 0; i< order.length; i++){
            Project current = order[i];
            if (current == null){
                return null;
            }
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
        }
        return order;
    }

    private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    private static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    private static String[] convertToStringList(Project[] projects) {
        String[] buildOrder = new String[projects.length];
        for (int i = 0; i < projects.length; i++) {
            buildOrder[i] = projects[i].getName();
        }
        return buildOrder;
    }
}

class Project {
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    private void incrementDependencies() {
        dependencies++;
    }
    public void decrementDependencies() {
        dependencies--;
    }

    public int getNumberDependencies() {
        return dependencies;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }
}

class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();


    public ArrayList<Project> getNodes() {
        return nodes;
    }

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project project = new Project(name);
            map.put(name, project);
            nodes.add(project);
            return project;
        }
        return map.get(name);
    }

    public void addEdge(String first, String second) {
        Project start = getOrCreateNode(first);
        Project end = getOrCreateNode(second);
        start.addNeighbor(end);
    }
}
