package Ch_16_Moderate.Q16_23_Rand7_From_Rand5.run2;

public class Solution {
    public static void main(String[] args) {
        /* Test: call rand7 many times and inspect the results. */
        int[] arr = new int[8];
        int test_size = 100000;
        for (int i = 0; i <= 13; i++) {
            System.out.println(i%7);
        }
        for (int k = 0; k < test_size; k++) {
            arr[rand7()]++;
        }

        for (int i = 0; i < 7; i++) {
            double percent = 100.0 * arr[i] / test_size;
            System.out.println(i + " appeared " + percent + "% of the time.");
        }
    }

    private static int rand7() {
        while (true) {
            int randm = 5 * rand5() + rand5() ;
            if (randm < 21) {
                return randm % 7;
            }
        }
    }

    private static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }

}
