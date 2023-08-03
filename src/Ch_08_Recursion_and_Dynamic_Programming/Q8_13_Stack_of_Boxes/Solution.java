package Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Solution {
    public static Box createRandomBox() {
        Random r = new Random();
        return new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100));
    }

    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int i = 0; i < 20; i++) {
            Box b = createRandomBox();
            boxes.add(b);
        }

        int height1 = createStack(boxes, 0, new ArrayList<>());
        System.out.println(height1);
    }

    private static int createStack(ArrayList<Box> boxes, int index, List<Integer> boxHiets) {
        if (index == boxes.size()) {
            return boxHiets.stream().min((o1, o2) -> Integer.compare(o2, o1)).get();
        }
        int maxHeight = boxes.get(index).getHeight();
        List<Box> stack = new ArrayList<>();
        stack.add(boxes.get(index));
        for (int i = 0; i < boxes.size(); i++) {
            if (checkIfPossiblePlace(boxes.get(i), stack.get(stack.size()-1))) {
                stack.add(boxes.get(i));
                maxHeight = Math.max(maxHeight, createStack(boxes, index + 1, stack));
            }
        }
        return stack.stream().mapToInt(Box::getHeight).sum();
    }

    private static boolean checkIfPossiblePlace(Box smallerBox, Box biggerBox) {
        return biggerBox.getDepth() > smallerBox.getDepth() && biggerBox.getHeight() > smallerBox.getHeight() && biggerBox.getWidth() > smallerBox.getWidth();
    }

    private static void createStack(ArrayList<Box> boxes, Box box, int maxHeigth) {

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

class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box box1, Box box2) {
        return 0;

    }
}
