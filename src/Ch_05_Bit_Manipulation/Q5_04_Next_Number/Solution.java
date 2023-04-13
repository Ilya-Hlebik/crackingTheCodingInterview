package Ch_05_Bit_Manipulation.Q5_04_Next_Number;

public class Solution {
    public static void binPrint(int i) {
        System.out.println(i + ": " + Integer.toBinaryString(i));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            int p1 = getPrevSlow(i);
            int p2 = getPrevSlow3(i);
             /*        int p2 = QuestionB.getPrev(i);
            int p3 = QuestionC.getPrevArith(i);
*/
            int n1 = getNextSlow(i);
            int n2 = getNextSlow2(i);
/*            int n2 = QuestionB.getNext(i);
            int n3 = QuestionC.getNextArith(i);*/

            if (p1 != p2) {
                System.out.println("----------");
                binPrint(i);
                binPrint(p1);
                binPrint(p2);
                System.out.println("----------");
            }
          /*  if (p1 != p2 || p2 != p3 || n1 != n2 || n2 != n3) {
                binPrint(i);
                binPrint(p1);
                binPrint(p2);
                binPrint(p3);
                binPrint(n1);
                binPrint(n2);
                binPrint(n3);
                System.out.println("");
                break;
            }*/
        }
        System.out.println("Done!");
    }

    private static int getNextSlow3(int i) {
        if (i == 0){
            return 0;
        }
        int count = getCountOf1(i);
        int newI = i + 1;
        while (getCountOf1(newI) != count) {
            newI++;
        }
        return newI;
    }

    private static int getNextSlow2(int i) {
        if (i == 0){
            return 0;
        }
        int count = getCountOf1(i);
        int newI = i + 1;
        while (getCountOf1(newI) != count) {
            newI++;
        }
        return newI;
    }


    private static int getPrevSlow2(int i) {
        if (i == 0){
            return 0;
        }
        if (i == 1){
            return 1;
        }
        int count = getCountOf1(i);
        int newI = i - 1;
        while (getCountOf1(newI) != count) {
            newI--;
        }
        return newI;
    }

    private static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1?1:0;
        int mask = ~(1 << i);
        return (num & mask) | value <<i;
    }

    private static int getPrevSlow3(int number) {
        if (number == 0){
            return 0;
        }
        if (number == 1){
            return 1;
        }
        int newI = number;
        for(int i =1; i < 1000; i++ ){
            if ((1<<i & number)!=0 && (1<<i-1 & number)==0){
                int temp = updateBit(number, i, false);
                newI =  updateBit(temp, i-1, true);
                break;
            }
        }
        return newI;
    }



    private static int getCountOf1(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) != 0) {
                count++;
            }
            i >>>= 1;
        }
        return count;
    }


    public static int countOnes(int i) {
        int count = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i = i >> 1;
        }
        return count;
    }

    public static int countZeros(int i) {
        return 32 - countOnes(i);
    }

    public static boolean hasValidNext(int i) {
        if (i == 0) {
            return false;
        }
        int count = 0;
        while ((i & 1) == 0) {
            i >>= 1;
            count++;
        }
        while ((i & 1) == 1) {
            i >>= 1;
            count++;
        }
        if (count == 31) {
            return false;
        }
        return true;
    }

    public static boolean hasValidPrev(int i) {
        while ((i & 1) == 1) {
            i >>= 1;
        }
        if (i == 0) {
            return false;
        }
        return true;
    }

    public static int getNextSlow(int i) {
        if (!hasValidNext(i)) {
            return -1;
        }
        int num_ones = countOnes(i);
        i++;
        while (countOnes(i) != num_ones) {
            i++;
        }
        return i;
    }

    public static int getPrevSlow(int i) {
        if (!hasValidPrev(i)) {
            return -1;
        }
        int num_ones = countOnes(i);
        i--;
        while (countOnes(i) != num_ones) {
            i--;
        }
        return i;
    }
}
