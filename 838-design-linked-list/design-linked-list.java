class MyLinkedList {

   // Node class
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    // Add at head
    public void addAtHead(int val) {

        ListNode newNode = new ListNode(val);

        newNode.next = head;
        head = newNode;

        size++;
    }

    // Add at tail
    public void addAtTail(int val) {

        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = newNode;
        size++;
    }

    // Add at index
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    // Delete at index
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */