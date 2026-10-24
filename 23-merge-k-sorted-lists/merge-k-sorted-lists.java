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
    public ListNode mergeKLists(ListNode[] lists) {

    
        // Agar lists null hain ya empty hain, toh null return karo
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Pehli linked list ko result maan lo
        ListNode result = lists[0];

        // Baaki sabhi lists ko ek-ek karke result ke saath merge karo
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        // Final merged linked list return karo
        return result;
    }

    // Do sorted linked lists ko merge karne ka function
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy starting node banaya, taaki first node handle karna easy ho
        ListNode dummy = new ListNode(0);

        // curr merged list ke current last node ko point karega
        ListNode curr = dummy;

        // Jab tak dono lists mein nodes available hain
        while (list1 != null && list2 != null) {

            // Agar list1 ka current value chhota ya equal hai
            if (list1.val <= list2.val) {

                // list1 ka current node result mein jodo
                curr.next = list1;

                // list1 ko agle node par move karo
                list1 = list1.next;

            } else {

                // list2 ka current node result mein jodo
                curr.next = list2;

                // list2 ko agle node par move karo
                list2 = list2.next;
            }

            // curr ko result ke naye last node par move karo
            curr = curr.next;
        }

        // Agar list1 mein nodes bache hain, toh unhe jod do
        if (list1 != null) {
            curr.next = list1;
        } else {

            // Warna list2 ke remaining nodes jod do
            curr.next = list2;
        }

        // Dummy node ko skip karke actual merged list return karo
        return dummy.next;
    }
} 


        
   