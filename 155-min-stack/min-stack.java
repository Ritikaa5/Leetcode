class MinStack {

   
    // Normal stack
    // Actual values store karega
    Stack<Integer> stack = new Stack<>();

    // Minimum stack
    // Har step tak ka minimum store karega
    Stack<Integer> minStack = new Stack<>();

    // Push element into stack
    public void push(int val) {

        // Value normal stack me add karo
        stack.push(val);

        // Agar minStack empty hai
        // ya new value current minimum se choti/equal hai
        // to new value ko minStack me push karo

        if (minStack.isEmpty() || val <= minStack.peek()) {

            minStack.push(val);
        }

        // Agar new value badi hai
        // to current minimum ko dubara push kar do
        // taaki har index par minimum stored rahe

        else {

            minStack.push(minStack.peek());
        }
    }

    // Remove top element
    public void pop() {

        // Dono stack se pop karna zaruri hai
        // taaki positions same rahe

        stack.pop();
        minStack.pop();
    }


    // Return top element
    public int top() {

        return stack.peek();
    }

    // Return minimum element
    public int getMin() {

        // minStack ka top hi minimum hota hai
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */