package Ch_16_Moderate.Q16_10_Living_People.run2;

import Ch_16_Moderate.Q16_10_Living_People.Person;

import java.util.Random;

import static Ch_16_Moderate.Q16_10_Living_People.run2.Solution.maxAliveYear;

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
        int yearB = maxAliveYear2(people, first, last);
        System.out.println("A: " + yearA);
        System.out.println("B: " + yearB);
    }

    public static int maxAliveYear2(Person[] people, int min, int max) {
        int[] deltas = new int[max - min + 2];
        for (Person person : people) {
            deltas[person.birth - min]++;
            deltas[person.death - min + 1]--;
        }
        int current = 0;
        int maxAliveYear = min;
        int maxAlive = Integer.MIN_VALUE;
        for (int i = 0; i < deltas.length; i++) {
            current +=deltas[i];
            if (current > maxAlive){
                maxAlive = current;
                maxAliveYear = i + min;
            }
        }
        return maxAliveYear;
    }
}
