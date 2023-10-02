package Ch_16_Moderate.Q16_25_LRU_Cache;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap<>();
        Solution solution = new Solution();
        solution.initCache(3);
        solution.putItem("1", "1");
        solution.putItem("2", "2");
        solution.putItem("3", "3");
        solution.findItem("1");
        solution.putItem("4", "4");
    }

    int capacity;
    Map<String, String> cache;
    List<String> order;

    public void initCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        order = new ArrayList<>();
    }

    public void putItem(String id, String item) {
        cache.put(id, item);
        if (order.size() == 0) {
            order.add(id);
        } else {
            order.add(0, id);
        }
        evictCacheIfNeeded();
    }

    public String findItem(String id) {
        if (cache.containsKey(id)) {
            order.remove(id);
            if (order.size() == 0) {
                order.add(id);
            } else {
                order.add(0, id);
            }
            return cache.get(id);
        }
        return null;
    }

    private void evictCacheIfNeeded() {
        if (capacity < cache.size()) {
            String key = order.get(order.size() - 1);
            cache.remove(key);
            order.remove(key);
        }
    }
}
