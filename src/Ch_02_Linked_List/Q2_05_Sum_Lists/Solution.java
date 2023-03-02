package Ch_02_Linked_List.Q2_05_Sum_Lists;

import CtCILibrary.LinkedListNode;

public class Solution {
    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedListNode tempNode = linkedListNode;
        int temp = 0;

        while (l1 !=null || l2!=null){
            int data = 0;
            if (l1 != null) {
                data =  l1.data;
            }
            int data1 = 0;
            if (l2 != null){
                data1 = l2.data;
            }
            int sum = data + data1 + temp;
            temp = 0;
            if (sum> 9){
                tempNode.data = sum %10;
                ++temp;
            }
            else {
                tempNode.data = sum + temp;
                temp = 0;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

            if ((l1 == null && l2 == null) && temp !=0){
                tempNode.next = new LinkedListNode();
                tempNode = tempNode.next;
                tempNode.data = temp;
            }
            else if (l1 == null && l2 == null){
                tempNode = null;
            }
            else {
                tempNode.next = new LinkedListNode();
                tempNode = tempNode.next;
            }
        }
        return linkedListNode;
    }


  /*  public static int linkedListToInt(LinkedListNode node) {

    }*/
  public static int linkedListToInt(LinkedListNode node) {
      int value = 0;
      if (node.next != null) {
          value = 10 * linkedListToInt(node.next);
      }
      return value + node.data;
  }
    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }
}
