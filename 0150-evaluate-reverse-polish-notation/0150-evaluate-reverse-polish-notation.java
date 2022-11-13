class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if(s.equals("-")) {
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2-n1);
            } else if(s.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if(s.equals("/")) {
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2/n1);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}