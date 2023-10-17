package Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.run2;

import Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.Graph;
import Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.Node;
import Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.State;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String a[]) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }

    private static boolean search(Graph graph, Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        for (Node u : graph.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        queue.add(start);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            poll.state = State.Visited;
            if (poll.equals(end)) {
                return true;
            }
            for (Node node : poll.getAdjacent()) {
                if (node.state == State.Unvisited) {
                    if (node.equals(end)) {
                        return true;
                    }
                    node.state = State.Visiting;
                    queue.add(node);
                }
            }
        }

        return false;
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }
}
