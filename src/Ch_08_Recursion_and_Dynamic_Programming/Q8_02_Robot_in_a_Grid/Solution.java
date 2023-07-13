package Ch_08_Recursion_and_Dynamic_Programming.Q8_02_Robot_in_a_Grid;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int size = 5;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
        AssortedMethods.printMatrix(maze);
        List<Point> pathA = getPath(maze);
    }

    private static List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        List<Point> path = new ArrayList<>();
        HashSet<Point> excluded = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, excluded)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, List<Point> path, HashSet<Point> excluded) {
        if (col < 0 && row < 0 || !maze[row][col]) {
            return false;
        }
        Point point = new Point(row, col);
        boolean itsAtOrigin = row == 0 && col == 0;
        if (!excluded.contains(point) || itsAtOrigin || getPath(maze, row, col - 1, path, excluded)
                || getPath(maze, row - 1, col, path, excluded)) {
            path.add(point);
            return true;
        }
        excluded.add(point);
        return false;
    }
}
