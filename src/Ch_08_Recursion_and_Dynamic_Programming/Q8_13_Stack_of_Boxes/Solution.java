package Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Solution {
    public static Box createRandomBox() {
        Random r = new Random();
        return new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100));
    }

    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int i = 0; i < 200; i++) {
            Box b = createRandomBox();
            boxes.add(b);
        }

        int height1 =  createStack(boxes);
        System.out.println(height1 );
    }

    private static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        return 0;
    }
}
class Box {
    public int width;
    public int height;
    public int depth;
    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
class BoxComparator implements Comparator<Box>{

    @Override
    public int compare(Box box1, Box box2) {


}
