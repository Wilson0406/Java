class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            // System.out.println(ch);
            if(st.isEmpty()) {
                st.push(ch);
                continue;
            }
            if(st.peek() == 'A' && ch == 'B') {
                st.pop();
            } else if(st.peek() == 'C' && ch == 'D') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }
}