class MinStack {
    Deque<Integer> stk;
    Deque<Integer> minstk;

    public MinStack() {
        stk = new ArrayDeque<>();
        minstk = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minstk.isEmpty()) minstk.push(val);
        else if(val <= minstk.peek()) minstk.push(val);
    }
    
    public void pop() {
        int curr = stk.pop();
        if(curr == minstk.peek()) minstk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstk.peek();
    }
}
