class MyQueue {

   Stack<Integer> input;
    Stack<Integer> output;

    // Constructor
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // ENQUEUE operation
    public void push(int x) {
        input.push(x);
    }

    // helper: transfer elements if needed
    private void transfer() {

        // only transfer when output is empty
        if(output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    // DEQUEUE operation
    public int pop() {

        transfer(); // ensure correct order

        if(output.isEmpty()) return -1; // queue empty

        return output.pop();
    }

    // FRONT element
    public int peek() {

        transfer(); // ensure correct order

        if(output.isEmpty()) return -1;

        return output.peek();
    }

    // CHECK empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */