package Ch_07_Object_Oriented_Design.Q7_12_Hash_Table.run2;


public class Solution {
    public static void main(String[] args) {
        Hasher<String, String> objectObjectHashTable = new Hasher<>(4);
        objectObjectHashTable.put("test", "test");
        objectObjectHashTable.put("test", "test2");
        objectObjectHashTable.put("test2", "test22");
        objectObjectHashTable.put("test3", "test3");
        System.out.println(objectObjectHashTable.get("test"));
    }
}
