package Ch_08_Recursion_and_Dynamic_Programming.Q8_10_Paint_Fill.run2;


import Ch_08_Recursion_and_Dynamic_Programming.Q8_10_Paint_Fill.Color;

public class Solution {
    public static void main(String[] args) {
        int N = 10;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.Black;
            }
        }
        for (int i = 0; i < 100; i++) {
            screen[randomInt(N)][randomInt(N)] = Color.Green;
        }
        PrintScreen(screen);
        PaintFill(screen, 2, 2, Color.White);
        System.out.println();
        PrintScreen(screen);
    }

    private static void PaintFill(Color[][] screen, int r, int c, Color color) {
        PaintFill(screen, r, c, screen[r][c], color);
    }

    private static void PaintFill(Color[][] screen, int r, int c, Color original, Color color) {
        if (r < 0 || r > screen.length - 1 || c < 0 || c > screen[r].length - 1) {
            return;
        }
        if (screen[r][c] != original || screen[r][c] == color) {
            return;
        }
        screen[r][c] = color;
        PaintFill(screen, r - 1, c, original, color);
        PaintFill(screen, r - 1, c + 1, original, color);
        PaintFill(screen, r, c + 1, original, color);
        PaintFill(screen, r + 1, c + 1, original, color);
        PaintFill(screen, r + 1, c, original, color);
        PaintFill(screen, r + 1, c - 1, original, color);
        PaintFill(screen, r, c - 1, original, color);
        PaintFill(screen, r - 1, c - 1, original, color);
    }

    private static void PrintScreen(Color[][] screen) {
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
}
