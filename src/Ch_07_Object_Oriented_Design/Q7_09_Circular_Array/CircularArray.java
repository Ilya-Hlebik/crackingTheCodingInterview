package Ch_07_Object_Oriented_Design.Q7_09_Circular_Array;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
    private int head = 0;
    private T[] items;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    private void set(int i, T valueOf) {
        items[convert(i)] = valueOf;
    }

    private void rotate(int i) {
        head = convert(i);
    }

    private T get(int i) {
        return items[convert(i)];
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {

        private int current = -1;

        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public T next() {
            current++;
            return items[current];
        }

    }

    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(3);
        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }
        System.out.println("");

        array.rotate(2);

        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }
    }
}
