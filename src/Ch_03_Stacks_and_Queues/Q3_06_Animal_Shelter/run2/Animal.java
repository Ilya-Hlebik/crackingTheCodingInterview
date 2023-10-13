package Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter.run2;

public class Animal {
    protected String name;
    protected long millisOfArrival = System.currentTimeMillis();

    public Animal(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public long getMillisOfArrival() {
        return millisOfArrival;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", millisOfArrival=" + millisOfArrival +
                '}';
    }
}
