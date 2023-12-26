package Ch_16_Moderate.Q16_10_Living_People.run2;

import Ch_16_Moderate.Q16_10_Living_People.Person;

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
        System.out.println("A: " + yearA);
    }

    public static int maxAliveYear(Person[] people, int min, int max) {
        int[] arr = new int[max - min+1];
        int maxAliveYear = min;
        int maxAlive = Integer.MIN_VALUE;
        for (Person person : people) {
            for (int i = person.birth - min; i <= person.death - min; i++) {
                arr[i]++;
                if (arr[i] > maxAlive) {
                    maxAlive = arr[i];
                    maxAliveYear = i + min;
                }
            }
        }
        return maxAliveYear;
    }
}
