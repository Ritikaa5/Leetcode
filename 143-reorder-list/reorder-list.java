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
    public void reorderList(ListNode head) {
    /*    1. Middle find karo
          2. Second half reverse karo
          3. Dono halves ko alternate merge karo
        */
        // Agar list empty hai ya sirf 1 node hai
        if (head == null || head.next == null) {
            return;
        }

       // STEP 1: Middle find karo
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }        // STEP 2: Second half ko reverse karo
        // =====================================

        ListNode prev = null;
        ListNode curr = slow.next;

        // First half aur second half ko alag karna
        slow.next = null;

        while (curr != null) {

            // Next node save karo
            ListNode nextNode = curr.next;

            // Link reverse karo
            curr.next = prev;

            // prev ko aage badhao
            prev = curr;

            // curr ko aage badhao
            curr = nextNode;
        }
        // prev second half ka head hai
        // Example:
        // 1 -> 2 -> 3
        // 5 -> 4


        // =====================================
        // STEP 3: Dono halves ko merge karo
        // =====================================

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            // First half ka next save karo
            ListNode firstNext = first.next;

            // Second half ka next save karo
            ListNode secondNext = second.next;

            // First node ko second node se connect
            first.next = second;
 // Second node ko first half ke next se connect
            second.next = firstNext;

            // First pointer aage
            first = firstNext;

            // Second pointer aage
            second = secondNext;
        }
    
    }
}