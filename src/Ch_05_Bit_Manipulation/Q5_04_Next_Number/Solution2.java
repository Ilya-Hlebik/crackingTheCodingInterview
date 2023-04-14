package Ch_05_Bit_Manipulation.Q5_04_Next_Number;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(getPrevious(118));
    }

    public static int getNext(int n) {
        int c0 = 0;
        int c1 = 0;
        int c = n;
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return 0;
        }
        int p = c0 + c1;
        n |= (1 << p);
        n &= ~0 << p;
        n |= (1 << (c1 - 1)) - 1;
        return n;
    }

    public static int getPrevious(int n) {
        int c0 = 0;
        int c1 = 0;
        int c = n;
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        if (c == 0) {
            return -1;
        }
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }
        int p = c0 + c1;
        n &= ~0 << (p + 1);
        n |= (1 << (c1 + 1)) - 1 << (c0 - 1);
        return n;
    }
}
