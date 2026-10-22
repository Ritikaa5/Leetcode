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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         // Step 1: Create starting node
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Step 2: Store carry
        int carry = 0;

        // Step 3: Continue while digits or carry remain
        while (l1 != null || l2 != null || carry != 0) {

            // Step 4: Start sum with carry
            int sum = carry;

            // Step 5: Add digit from l1
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Step 6: Add digit from l2
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Step 7: Calculate digit and carry
            int digit = sum % 10;
            carry = sum / 10;

            // Step 8: Create and attach new node
            ListNode newNode = new ListNode(digit);
            curr.next = newNode;
            curr = curr.next;
        }

        // Step 9: Return answer, skipping dummy node
        return dummy.next;
    }
}