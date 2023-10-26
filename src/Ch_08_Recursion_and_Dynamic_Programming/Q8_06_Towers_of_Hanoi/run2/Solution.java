package Ch_08_Recursion_and_Dynamic_Programming.Q8_06_Towers_of_Hanoi.run2;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Tower source = new Tower();
        Tower destination = new Tower();
        Tower buffer = new Tower();

        source.name = "source";
        destination.name = "destination";
        buffer.name = "buffer";

        /* Load up tower */
        int numberOfDisks = 3;
        for (int disk = numberOfDisks - 1; disk >= 0; disk--) {
            source.add(disk);
        }

        source.print();
        source.moveDisks(numberOfDisks, destination, buffer);
        destination.print();
    }

    private static class Tower {
        public String name;
        private Stack<Integer> disks = new Stack<Integer>();


        public void add(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                System.out.println("Error placing disk " + disk);

            } else {
                disks.push(disk);
            }
        }

        public void print() {
            System.out.println("Contents of Tower " + name + ": " + disks.toString());
        }

        public void moveDisks(int numberOfDisks, Tower destination, Tower buffer) {
            if (numberOfDisks <= 0) {
                return;
            }
            this.moveDisks(numberOfDisks - 1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(numberOfDisks - 1, destination, this);

        }

        public void moveTop(Tower destination) {
            destination.add(disks.pop());
        }
    }
}
