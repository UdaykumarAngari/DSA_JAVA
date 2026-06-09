class MyStack {
    Queue<Integer> q ;
    public MyStack() {
        q = new LinkedList<>();
    }  
    
    public void push(int x) {
        int s = q.size();

        q.add(x);
        for(int i = 0 ; i < s ; i++){
            q.add(q.poll());
        }
    }
    
    public int pop() {
        int n = q.peek();
        q.poll();
        return n;
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
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