class Solution {
    public int minSwaps(String s) {
        // Stack<Character> st = new Stack<>();
        int swaps = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[') {
                // st.push(ch);
                swaps++;
            } else {
                if(swaps > 0) swaps--;
                // if(!st.isEmpty()) st.pop();
            }
        }
        return (swaps + 1) / 2;
        // return (st.size() + 1) / 2;
    }
}