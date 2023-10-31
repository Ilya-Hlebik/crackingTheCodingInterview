package Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes.run2;


import Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes.Box;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int i = 0; i < 200; i++) {
            Box b = createRandomBox();
            boxes.add(b);
        }
        boxes.sort(Comparator.comparing(Box::getHeight).reversed());
        int height1 = createStack(boxes);
        int height2 = new Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes.Solution().createStack(boxes);
        System.out.println(height1);
        System.out.println(height2);
    }

    private static int createStack(ArrayList<Box> boxes) {
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            maxHeight = Math.max(maxHeight, createStack(boxes, i, new int[boxes.size()+1]));
        }
        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int startIndex, int[] memo) {
        if (memo[startIndex] != 0){
            return memo[startIndex];
        }
        Box lastBox = boxes.get(startIndex);
        int maxHeight = 0;

        for (int i = startIndex + 1; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            if (lastBox.getHeight() > currentBox.getHeight()
                    && lastBox.getWidth() > currentBox.getWidth()
                    && lastBox.getDepth() > currentBox.getDepth()) {
                int height = createStack(boxes, i, memo);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += lastBox.height;
        memo[startIndex] = maxHeight;
        return maxHeight;
    }

    public static Box createRandomBox() {
        Random r = new Random();
        return new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100));
    }
}
