package Ch_08_Recursion_and_Dynamic_Programming.Q8_02_Robot_in_a_Grid;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int size = 5;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
        AssortedMethods.printMatrix(maze);
        ArrayList<Point> pathA =  getPath(maze);
    }

    private static ArrayList<Point> getPath(boolean[][] maze) {


    }
}
