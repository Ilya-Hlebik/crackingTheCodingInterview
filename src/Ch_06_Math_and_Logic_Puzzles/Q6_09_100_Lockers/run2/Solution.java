package Ch_06_Math_and_Logic_Puzzles.Q6_09_100_Lockers.run2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(open100Lockers());
    }

    private static long open100Lockers() {
        List<Locker> collect = IntStream.range(1, 101)
                .mapToObj(value -> new Locker())
                .collect(Collectors.toList());
        for (int i = 1; i <= 100; i++) {
            int lockerNumber = i - 1;
            while (lockerNumber < 100) {
                Locker locker = collect.get(lockerNumber);
                locker.setOpen(!locker.isOpen);
                lockerNumber += i;
            }
        }
        return collect.stream().filter(Locker::isOpen).count();
    }
}

class Locker {
    boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
