package Ch_16_Moderate.Q16_25_LRU_Cache.run2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        int cache_size = 5;
        Cache cache = new Cache(cache_size);

        cache.setKeyValue(1, "1");
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(2, "2");
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(3, "3");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(4, "4");
        System.out.println(cache.getCacheAsString());
        cache.getValue(2);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(5, "5");
        System.out.println(cache.getCacheAsString());
        cache.getValue(5);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(6, "6");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(5, "5a");
        System.out.println(cache.getCacheAsString());
        cache.getValue(3);
        System.out.println(cache.getCacheAsString());
        // 6->5->2->4->1
    }
}

class Cache {
    private final int cacheSize;
    private final LinkedList<Pair> linkedList = new LinkedList<>();
    private final Map<Integer, Pair> keys = new HashMap<>();

    public Cache(int cache_size) {
        this.cacheSize = cache_size;
    }

    public void setKeyValue(int key, String value) {
        if (keys.containsKey(key)) {
            Pair integerStringEntry = keys.get(key);
            integerStringEntry.setValue(value);
        } else {
            evictLeastElementIfNeeded();
            Pair pair = new Pair(key, value);
            linkedList.add(pair);
            keys.put(key, pair);
        }
    }

    private void evictLeastElementIfNeeded() {
        if (linkedList.size() == cacheSize) {
            Pair last = linkedList.getLast();
            keys.remove(last.getKey());
            linkedList.removeLast();
        }
    }

    public String getCacheAsString() {
        return linkedList.toString();
    }

    public String getValue(int key) {
        if (keys.containsKey(key)) {
            Pair integerStringEntry = keys.get(key);
            linkedList.remove(integerStringEntry);
            linkedList.addFirst(integerStringEntry);
            return integerStringEntry.getValue();
        }
        return null;
    }
}

class Pair {
    private Integer key;
    private String value;

    public Pair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return " key=" + key + ", value='" + value + '\'';
    }
}
