class MinStack {
    Stack<Integer> numstack ;
    Stack<Integer> minstack ;
    public MinStack() {
        numstack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int value) {
        if(numstack.isEmpty()){
            numstack.push(value);
            minstack.push(value);
        }
        else{
            numstack.push(value);
            if(value <=minstack.peek()){
                minstack.push(value);

            }
        }
    }
    
    public void pop() {
        if(numstack.isEmpty()){
            return;
        }
        else{
           int value =  numstack.pop();
           if(value == minstack.peek()){
            minstack.pop();
           }
        }
    }
    
    public int top() {
        return numstack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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