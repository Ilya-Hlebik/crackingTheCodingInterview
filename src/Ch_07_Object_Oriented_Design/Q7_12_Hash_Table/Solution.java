package Ch_07_Object_Oriented_Design.Q7_12_Hash_Table;

public class Solution {
    public static void main(String[] args) {
        HashTable<String, String> objectObjectHashTable = new HashTable<>(4);
        objectObjectHashTable.put("test", "test");
        objectObjectHashTable.put("test", "test2");
        objectObjectHashTable.put("test2", "test22");
        objectObjectHashTable.put("test3", "test3");
        objectObjectHashTable.remove("test");
        System.out.println(objectObjectHashTable.get("test"));
    }
}
