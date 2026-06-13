class MyStack {

     // we use only one queue
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // push element into stack
    public void push(int x) {

        // step 1: add element in queue
        q.add(x);

        // step 2: rotate queue to make x front element
        int size = q.size();

        // move all previous elements behind x
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    // remove top element (stack pop)
    public int pop() {

        // if empty return -1
        if (q.isEmpty()) {
            return -1;
        }

        // front of queue is stack top
        return q.remove();
    }

    // get top element
    public int top() {

        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    // check empty
    public boolean empty() {
        return q.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */