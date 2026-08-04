class Solution {
    public int evalRPN(String[] str) {
        Stack<Integer> st = new Stack<>();
        for(String s: str){
            if(s.equals("+") ||s.equals("-") || s.equals("*") || s.equals("/") ){
                int b=st.pop();
                int a=st.pop();
                int res=0;
                switch(s){
                     case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }
                st.push(res);

            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();

    }
}