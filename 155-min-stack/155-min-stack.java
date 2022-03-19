class MinStack {
    private int min = Integer.MAX_VALUE, top = 0;
    private ArrayList<Integer> stack = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        top++;
        if(min > val) min = val;
    }
    
    public void pop() {
        int toReturn = stack.get(top - 1);
        stack.remove(top - 1);
        top--;
        if(min == toReturn) {
            min = Integer.MAX_VALUE;
            for(int n : stack) {
                min = Math.min(min, n);
            }
        }
    }
    
    public int top() {
        return stack.get(top - 1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */