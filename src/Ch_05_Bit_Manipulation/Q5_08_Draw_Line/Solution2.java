package Ch_05_Bit_Manipulation.Q5_08_Draw_Line;

import static Ch_05_Bit_Manipulation.Q5_08_Draw_Line.Solution.printScreen;

public class Solution2 {
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int rowOffset = y * width;
        int startOffset = rowOffset + x1;
        byte startMask = (byte) (0xFF >> (x1 % 8));
        byte endMask = (byte) ~(0xFF >> (x2 % 8 + 1));
        byte mask = (byte) (startMask & endMask);
        screen[startOffset / 8] |= mask;
    }

    public static void main(String[] args) {
        int width = 8 * 1;
        int height = 2;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    drawLine(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println("\n\n");
                }
            }
        }
    }
}
