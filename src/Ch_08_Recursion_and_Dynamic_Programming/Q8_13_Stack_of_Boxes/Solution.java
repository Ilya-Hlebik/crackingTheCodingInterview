package Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
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
        boxes.sort(Comparator.comparing(Box::getHeight).reversed());
        int height2 = new Solution2().createStack(boxes);
        System.out.println(height2);
        int height1 = createStack(boxes);
        System.out.println(height1);
    }

    private static int createStack(ArrayList<Box> boxes) {
        int maxHegth = 0;
        int[] memo = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            maxHegth = Math.max(maxHegth, createStack(boxes, i, memo));
        }
        return maxHegth;
    }

    private static int createStack(ArrayList<Box> boxes, int index, int[] memo) {
        if (memo[index] > 0) {
            return memo[index];
        }
        int maxHeight = 0;
        Box currentBox = boxes.get(index);
        for (int i = index + 1; i < boxes.size(); i++) {
            if (checkIfPossiblePlace(boxes.get(i), currentBox)) {
                int height = createStack(boxes, i, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += currentBox.height;
        memo[index] = maxHeight;
        return maxHeight;
    }

    private static boolean checkIfPossiblePlace(Box smallerBox, Box biggerBox) {
        return biggerBox.getDepth() > smallerBox.getDepth() && biggerBox.getHeight() > smallerBox.getHeight() && biggerBox.getWidth() > smallerBox.getWidth();
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

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        return width < b.width && height < b.height && depth < b.depth;
    }
}

