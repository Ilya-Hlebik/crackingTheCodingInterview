package Ch_16_Moderate.Q16_10_Living_People;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int n = 100;
        int first = 1900;
        int last = 2000;

        Random random = new Random();
        Person[] people = new Person[n + 1];
        for (int i = 0; i < n; i++) {
            int birth = first + random.nextInt(last - first);
            int death = birth + random.nextInt(last - birth);
            people[i] = new Person(birth, death);
            //System.out.println(birth + ", " + death);
        }
        people[n] = new Person(first, first);

        int yearA = maxAliveYear(people, first, last);
        int yearB = maxAliveYearB(people, first, last);
        int yearC = Solution2.maxAliveYear(people, first, last);
        System.out.println("A: " + yearA);
        System.out.println("B: " + yearB);
        System.out.println("C: " + yearC);
    }

    private static int maxAliveYear(Person[] people, int first, int last) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int year = first; year <= last; year++) {
            for (Person person : people) {
                if (person.birth <= year && person.death >= year) {
                    Integer value = map.getOrDefault(year, 0);
                    map.put(year, ++value);
                }
            }
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    private static int maxAliveYearB(Person[] people, int first, int last) {
        int maxAlive = 0;
        int maxYear = last;

        for (int year = first; year <= last; year++) {
            int alive = 0;
            for (Person person : people) {
                if (person.birth <= year && person.death >= year) {
                    alive++;
                }
            }
            if (alive > maxAlive) {
                maxAlive = alive;
                maxYear = year;
            }
        }
        return maxYear;
    }
}
