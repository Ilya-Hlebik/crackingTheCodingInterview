package Ch_07_Object_Oriented_Design.Q7_12_Hash_Table.run2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hasher<K, V> {
    private class LinkedListNode {
        public LinkedListNode prev;
        public LinkedListNode next;
        public K key;
        public V value;

        public LinkedListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final List<LinkedListNode> arr;

    public Hasher(int capacity) {
        arr = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V put(K key, V value) {
        LinkedListNode node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        int indexForKey = getIndexForKey(key);
        node = new LinkedListNode(key, value);
        LinkedListNode arrByIndex = arr.get(indexForKey);
        if (arrByIndex != null) {
            node.next = arrByIndex;
            arrByIndex.prev = node;
        }
        arr.set(indexForKey, node);
        return null;
    }

    public V remove(K key) {
        LinkedListNode nodeForKey = getNodeForKey(key);
        if (nodeForKey == null) {
            return null;
        }
        if (nodeForKey.prev != null) {
            nodeForKey.prev.next = nodeForKey.next;
        } else {
            int indexForKey = getIndexForKey(key);
            arr.set(indexForKey, nodeForKey.next);
        }
        if (nodeForKey.next != null) {
            nodeForKey.next.prev = nodeForKey.prev;
        }
        return nodeForKey.value;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        return Optional.ofNullable(getNodeForKey(key)).map(kvLinkedListNode -> kvLinkedListNode.value).orElse(null);
    }

    private LinkedListNode getNodeForKey(K key) {
        int indexForKey = getIndexForKey(key);
        LinkedListNode arrByIndex = arr.get(indexForKey);
        while (arrByIndex != null) {
            if (arrByIndex.key == key) {
                return arrByIndex;
            }
            arrByIndex = arrByIndex.next;
        }
        return null;
    }

    public int getIndexForKey(K key) {
        return key.hashCode() % arr.size();
    }
}
