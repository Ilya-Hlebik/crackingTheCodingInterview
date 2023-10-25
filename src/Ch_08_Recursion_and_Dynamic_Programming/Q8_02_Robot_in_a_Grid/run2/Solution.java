package Ch_08_Recursion_and_Dynamic_Programming.Q8_02_Robot_in_a_Grid.run2;

import Ch_08_Recursion_and_Dynamic_Programming.Q8_02_Robot_in_a_Grid.Point;
import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int size = 20;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 90);

        AssortedMethods.printMatrix(maze);

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println(path.toString());
        } else {
            System.out.println("No path found.");
        }
    }

    private static ArrayList<Point> getPath(boolean[][] maze) {
        ArrayList<Point> pointList = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        boolean path = getPath(maze, maze.length - 1, maze[maze.length - 1].length - 1, pointList, set);
        if (path) {
            return pointList;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int i, int j, ArrayList<Point> pointList, Set<Point> set) {
        if (i < 0 || j < 0 || !maze[i][j]) {
            return false;
        }
        Point point = new Point(i, j);
        boolean atOrigin = i == 0 && j == 0;
        if (!set.contains(point) && (atOrigin || getPath(maze, i - 1, j, pointList, set) || getPath(maze, i, j - 1, pointList, set))) {
            pointList.add(point);
            return true;
        }
        set.add(point);
        return false;
    }
}
