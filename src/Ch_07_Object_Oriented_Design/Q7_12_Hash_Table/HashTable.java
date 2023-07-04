package Ch_07_Object_Oriented_Design.Q7_12_Hash_Table;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class HashTable<K, V> {
    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> previous;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public HashTable(int capacity) {
        list.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(null);
        }
    }

    private final ArrayList<Node<K, V>> list = new ArrayList<>();

    public V put(K key, V value) {
        AtomicReference<V> old = new AtomicReference<>();
        Optional<Node<K, V>> nodeForKey = getNodeForKey(key);
        nodeForKey.ifPresentOrElse(kvNode -> {
            old.set(kvNode.getValue());
            kvNode.setValue(value);
        }, () -> {
            int index = getIndexForKey(key);
            Node<K, V> element = new Node<>(key, value);
            if (list.get(index) != null){
                element.next = list.get(index);
                element.next.previous = element;
            }
            list.set(index, element);
        });
        return old.get();
    }

    private Optional<Node<K, V>> getNodeForKey(K key) {
        return list.stream().filter(Objects::nonNull).filter(kvNode -> kvNode.getKey().equals(key)).findAny();
    }

    public int getIndexForKey(K key) {
        return list.size() == 0? 0: Math.abs(key.hashCode() % list.size());
    }

    public V get(K key) {
        return getNodeForKey(key).map(Node::getValue).orElse(null);
    }

    public V remove(K key) {
        Optional<Node<K, V>> nodeForKey = getNodeForKey(key);
        if (nodeForKey.isPresent()) {
            if (nodeForKey.get().previous != null){
                nodeForKey.get().previous.next = nodeForKey.get().next;
            }
            else {
                int indexForKey = getIndexForKey(key);
                list.set(indexForKey, nodeForKey.get().next);
            }
            if (nodeForKey.get().next != null){
                nodeForKey.get().next.previous = nodeForKey.get().previous;
            }
            return nodeForKey.get().getValue();
        }
        return null;
    }

    public void putAll(HashTable<K, V> hashTable) {
        hashTable.list.forEach(kvNode -> put(kvNode.getKey(), kvNode.getValue()));
    }

    public boolean containsKey(K key) {
        return getNodeForKey(key).isPresent();
    }
}
