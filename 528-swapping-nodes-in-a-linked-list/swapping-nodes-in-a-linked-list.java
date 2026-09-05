/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
         // First k-th node find karo
        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Second k-th node from end find karne ke liye
        ListNode fast = first;
        ListNode second = head;

        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Dono nodes ki values swap karo
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}