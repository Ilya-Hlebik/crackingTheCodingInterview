package Ch_06_Math_and_Logic_Puzzles.Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int currentPoisoned = 1;
    static int totalTo = 10000;
    static int totalFrom = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 115; i < 10000; i++) {
            currentPoisoned = i;
            totalTo = 10000;
            totalFrom = 0;
            System.out.println(solution.amountOfDays());
        }
    }

    int amountOfDays() {
        int countOfDays = 0;
        int countOfTests = 10;
        while (countOfTests > 0) {
            int each = (totalTo - totalFrom) / countOfTests;
            if (each == 0){
                each = 1;
            }
            List<Pair> tests = new ArrayList<>();
            for (int i = 0; i < countOfTests && totalTo != 0; i++) {
                int currentTest;
                Pair pair = new Pair();
                if (i+1 == countOfTests) {
                    pair.setTo(totalTo);
                    pair.setFrom(totalFrom);
                } else {
                    currentTest = totalTo - each;
                    pair.setTo(totalTo);
                    totalTo  = currentTest;
                    pair.setFrom(totalTo);
                }
                tests.add(pair);
                if (pair.getFrom() == totalFrom){
                    break;
                }
            }
            countOfDays += 7;
            for (Pair test : tests) {
                boolean poisoned = isPoisoned(test);
                if (poisoned && test.getFrom() +1 != test.getTo()) {
                    countOfTests--;
                    totalFrom = test.getFrom();
                    totalTo = test.getTo();
                    break;
                } else if (poisoned) {
                    System.out.print("currentPoisoned: " + test.getTo() + " amountOfDays:");
                    return countOfDays;
                }
            }
        }
        return countOfDays;
    }

    boolean isPoisoned(Pair pair) {
        return pair.getFrom() < currentPoisoned && pair.getTo() >= currentPoisoned;
    }
}

class Pair {
    int from;
    int to;


    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
