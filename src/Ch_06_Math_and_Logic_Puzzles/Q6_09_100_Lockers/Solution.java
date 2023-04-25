package Ch_06_Math_and_Logic_Puzzles.Q6_09_100_Lockers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Locker> lockers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            lockers.add(new Locker(i, true));
        }
        for (int i = 1; i<=100; i++){
            for (Locker current : lockers) {
                if (current.getNumber() % i == 0) {
                    current.setLocked(!current.isLocked);
                }
            }
        }
        lockers.stream()
                .filter(locker ->! locker.isLocked)
                .forEach(System.out::println);
        System.out.println();
    }
}

class Locker{
    int number;
    boolean isLocked;

    public Locker(int number, boolean isLocked) {
        this.number = number;
        this.isLocked = isLocked;
    }

    public int getNumber() {
        return number;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "number=" + number +
                ", isLocked=" + isLocked +
                '}';
    }
}
