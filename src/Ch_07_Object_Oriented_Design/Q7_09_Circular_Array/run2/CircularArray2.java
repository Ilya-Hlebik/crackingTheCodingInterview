package Ch_07_Object_Oriented_Design.Q7_09_Circular_Array.run2;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArray2<T> implements Iterable<T> {
    public T[] items;
    public int lastIndex;
    int head = 0;

    public CircularArray2() {
        this.items = (T[]) new Object[0];
        this.lastIndex = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator2();
    }

    public void rotate(int shiftRight) {
        head += shiftRight;
    }

    public void add(T item) {
        if (lastIndex >= items.length - 1) {
            items = Arrays.copyOf(items, items.length + 1);
        }
        items[lastIndex++] = item;
    }

    public T get(int index){
        if (index > lastIndex || index< 0){
            throw new IndexOutOfBoundsException("Out of bound index " + index);
        }
        return items[(head + index) % items.length];
    }

    class CircularArrayIterator2 implements Iterator<T> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < items.length;
        }

        @Override
        public T next() {
            return items[(head + current++) % items.length];
        }
    }
}


class Sol {
    public static void main(String[] args) {
        CircularArray2<String> objectCircularArray2 = new CircularArray2<>();
        objectCircularArray2.add("1");
        objectCircularArray2.add("2");
        objectCircularArray2.add("3");
        objectCircularArray2.add("4");
        objectCircularArray2.add("5");
        objectCircularArray2.rotate(2);
        for (String item : objectCircularArray2) {
            System.out.println(item);
        }
        System.out.println(objectCircularArray2.get(0));
    }
}
