package Ch_06_Math_and_Logic_Puzzles.Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.Random;

public class Solution2 {
    public static ArrayList<Bottle> createBottles(int nBottles, int poisoned) {
        ArrayList<Bottle> bottles = new ArrayList<Bottle>();
        for (int i = 0; i < nBottles; i++) {
            bottles.add(new Bottle(i));
        }

        if (poisoned == -1) {
            Random random = new Random();
            poisoned = random.nextInt(nBottles);
        }
        bottles.get(poisoned).setAsPoisoned();

        System.out.println("Added poison to bottle " + poisoned);

        return bottles;
    }

    public static int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
        runTests(bottles, strips);
        ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
        return setBits(positive);
    }

    /* Add bottles to test strips */
    public static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
        for (Bottle bottle : bottles) {
            int id = bottle.getId();
            int bitIndex = 0;
            while (id > 0) {
                if ((id & 1) == 1) {
                    testStrips.get(bitIndex).addDropOnDay(0, bottle);
                }
                bitIndex++;
                id >>= 1;
            }
        }
    }

    /* Get test strips that are positive on a particular day. */
    public static ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
        ArrayList<Integer> positive = new ArrayList<Integer>();
        for (TestStrip testStrip : testStrips) {
            int id = testStrip.getId();
            if (testStrip.isPositiveOnDay(day)) {
                positive.add(id);
            }
        }
        return positive;
    }

    /* Create number by setting bits with indices specified in positive. */
    public static int setBits(ArrayList<Integer> positive) {
        int id = 0;
        for (Integer bitIndex : positive) {
            id |= 1 << bitIndex;
        }
        return id;
    }

    public static ArrayList<TestStrip> createTestStrips(int nTestStrips) {
        ArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();
        for (int i = 0; i < nTestStrips; i++) {
            testStrips.add(new TestStrip(i));
        }
        return testStrips;
    }

    public static void main(String[] args) {
        int nBottles = 1000;
        int nTestStrips = 10;
        for (int poisoned = 0; poisoned < nBottles; poisoned++) {
            ArrayList<Bottle> bottles = createBottles(nBottles, poisoned);
            ArrayList<TestStrip> testStrips = createTestStrips(nTestStrips);
            int poisonedId = findPoisonedBottle(bottles, testStrips);
            System.out.println("Suspected Bottle: " + poisonedId);
            if (poisonedId != poisoned) {
                System.out.println("ERROR");
                break;
            }
        }
    }
}

class Bottle {
    private boolean poisoned = false;
    private int id;

    public Bottle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAsPoisoned() {
        poisoned = true;
    }

    public boolean isPoisoned() {
        return poisoned;
    }
}

class TestStrip {
    public static int DAYS_FOR_RESULT = 7;
    private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
    private int id;

    public TestStrip(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /* Resize list of days/drops to be large enough. */
    private void sizeDropsForDay(int day) {
        while (dropsByDay.size() <= day) {
            dropsByDay.add(new ArrayList<Bottle>());
        }
    }

    /* Add drop from bottle on specific day. */
    public void addDropOnDay(int day, Bottle bottle) {
        sizeDropsForDay(day);
        ArrayList<Bottle> drops = dropsByDay.get(day);
        drops.add(bottle);
    }

    /* Checks if any of the bottles in the set are poisoned. */
    private boolean hasPoison(ArrayList<Bottle> bottles) {
        for (Bottle b : bottles) {
            if (b.isPoisoned()) {
                return true;
            }
        }
        return false;
    }

    /* Gets bottles that were used in the test DAYS_FOR_RESULT days ago. */
    public ArrayList<Bottle> getLastWeeksBottles(int day) {
        if (day < DAYS_FOR_RESULT) {
            return null;
        }
        return dropsByDay.get(day - DAYS_FOR_RESULT);
    }

    /* Checks if the test strip has had any poisoned bottles since before DAYS_FOR_RESULT */
    public boolean isPositiveOnDay(int day) {
        int testDay = day - DAYS_FOR_RESULT;
        if (testDay < 0 || testDay >= dropsByDay.size()) {
            return false;
        }
        for (int d = 0; d <= testDay; d++) {
            ArrayList<Bottle> bottles = dropsByDay.get(d);
            if (hasPoison(bottles)) {
                return true;
            }
        }
        return false;
    }
}
