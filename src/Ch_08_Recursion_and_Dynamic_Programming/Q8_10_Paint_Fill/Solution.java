package Ch_08_Recursion_and_Dynamic_Programming.Q8_10_Paint_Fill;

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


    private static void PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if (r > screen.length - 1 || r < 0 || c > screen[r].length - 1 || c < 0 || ncolor == screen[r][c] || ocolor != screen[r][c]) {
            return;
        }
        screen[r][c] = ncolor;
        PaintFill(screen, r - 1, c - 1,ocolor, ncolor);
        PaintFill(screen, r - 1, c, ocolor, ncolor);
        PaintFill(screen, r - 1, c + 1, ocolor, ncolor);
        PaintFill(screen, r, c + 1, ocolor, ncolor);
        PaintFill(screen, r + 1, c + 1, ocolor, ncolor);
        PaintFill(screen, r + 1, c, ocolor, ncolor);
        PaintFill(screen, r + 1, c - 1, ocolor, ncolor);
        PaintFill(screen, r, c - 1, ocolor, ncolor);
    }

    private static void PaintFill(Color[][] screen, int r, int c, Color ncolor) {
        PaintFill(screen, r, c, screen[r][c], ncolor);
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

