class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    int top = 0;
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        if(q1.size() == 0) q2.offer(x);
        else q1.offer(x);
        top = x;        
    }
    
    public int pop() {
        if(q1.size() == 0) {
            moveExceptLast(q2, q1);
            return q2.poll();
        } else {
            moveExceptLast(q1, q2);
            return q1.poll();
        }
        
    }
    
    void moveExceptLast(Queue<Integer> from, Queue<Integer> to) {
        if(from.size() == 1) return;
        while(from.size() > 2) to.offer(from.poll());
        top = from.peek();
        to.offer(from.poll());
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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