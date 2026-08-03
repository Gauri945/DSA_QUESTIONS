class MinStack {

  Stack<Integer> st ;
  int min;

    public MinStack() {
        st=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(value<=min){
            st.push(min);
            min=value;
        }
        st.push(value);
    }
    
    public void pop() {
        if(st.pop()==min){
            min=st.pop();
            }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

