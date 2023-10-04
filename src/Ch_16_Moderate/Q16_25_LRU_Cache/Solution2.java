package Ch_16_Moderate.Q16_25_LRU_Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution2 {
    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap<>();
        Solution2 solution = new Solution2();
        solution.initCache(3);
        solution.putItem(1, "1");
        solution.putItem(2, "2");
        solution.putItem(3, "3");
        solution.findItem(1);
        solution.putItem(4, "4");
        System.out.println();
    }

    int capacity;
    Map<Integer, LinkedListNode> cache;
    LinkedListNode head;
    LinkedListNode tail;

    public void initCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public void putItem(int id, String item) {
        removeKey(id);
        if (capacity == cache.size()) {
            int key = tail.key;
            removeKey(key);
        }
        LinkedListNode linkedListNode = new LinkedListNode(id, item);

        insertInFrontOfLinkedList(linkedListNode);
        cache.put(id, linkedListNode);
    }

    private LinkedListNode insertInFrontOfLinkedList(LinkedListNode linkedListNode) {
        if (head == null) {
            head = linkedListNode;
            tail = linkedListNode;
        } else {
            head.prev = linkedListNode;
            linkedListNode.next = head;
            head = linkedListNode;
            head.prev = null;
        }
        return linkedListNode;
    }

    private void removeKey(int id) {
        LinkedListNode node = cache.get(id);
        removeFromLinkedList(node);
        cache.remove(id);
    }

    private void removeFromLinkedList(LinkedListNode node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }

    public String findItem(Integer id) {
        LinkedListNode item = cache.get(id);
        if (item == null) {
            return null;
        }
        if (item != head) {
            removeFromLinkedList(item);
            insertInFrontOfLinkedList(item);
        }
        return item.value;
    }
}

class LinkedListNode {
    public int key;
    public String value;
    public LinkedListNode next, prev;

    public LinkedListNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
