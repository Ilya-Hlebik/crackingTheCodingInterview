package Ch_16_Moderate.Q16_10_Living_People;

import java.util.Random;

public class Solution2 {
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
        System.out.println("A: " + yearA);
    }

    public static int maxAliveYear(Person[] people, int min, int max) {
        int[] deltas = getDeltas(people, min, max);
        int alive = getMaxAliveByDeltas(deltas);

        return min + alive;
    }

    private static int getMaxAliveByDeltas(int[] deltas) {
        int maxYear = 0;
        int maxAlive = 0;
        int current = 0;
        for (int i = 0; i < deltas.length; i++) {
           current += deltas[i];
           if (current > maxAlive){
               maxYear = i;
               maxAlive = current;
           }
        }
        return maxYear;
    }

    private static int[] getDeltas(Person[] people, int min, int max) {
        int[] delta = new int[max - min + 1];
        for (Person person : people) {
            delta[person.birth - min]++;
            delta[person.death - min + 1]--;
        }
        return delta;
    }
}
