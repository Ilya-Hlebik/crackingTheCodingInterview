package Ch_06_Math_and_Logic_Puzzles.Q6_10_Test_Strips.run2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static int currentPoisoned = 1;
    static int totalTo = 999;
    static int totalFrom = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 118; i < 1000; i++) {
            currentPoisoned = i;
            totalTo = 999;
            totalFrom = 0;
            System.out.println(solution.amountOfDays());
        }
    }

    private int amountOfDays() {
        int currentAmountOfDays = 0;
        List<Stripe> stripes = IntStream.range(0, 10).mapToObj(value -> new Stripe()).collect(Collectors.toList());
        while (totalFrom != totalTo) {
            stripes.forEach(stripe -> stripe.getDrops().clear());
            int amountOfDropsByStripe = ((totalTo - totalFrom) / stripes.size()) + 1;
            int currentAmount = 0;
            for (int i = totalFrom, j = 0; i <= totalTo; i++) {
                stripes.get(j).getDrops().add(i);
                currentAmount++;
                if (currentAmount == amountOfDropsByStripe) {
                    currentAmount = 0;
                    if (j != stripes.size() - 1) {
                        j++;
                    }
                }
            }
            for (Stripe stripe : stripes) {
                List<Integer> drops = stripe.getDrops();
                if (drops.contains(currentPoisoned)) {
                    totalFrom = drops.get(0);
                    totalTo = drops.get(drops.size() - 1);
                    stripes.remove(stripe);
                    break;
                }
            }
            currentAmountOfDays += 7;
        }

        return currentAmountOfDays;
    }
}

class Stripe {
    List<Integer> drops = new ArrayList<>();

    public List<Integer> getDrops() {
        return drops;
    }
}
