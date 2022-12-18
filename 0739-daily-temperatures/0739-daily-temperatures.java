class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] map = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer top = stack.pop();
                int diff = i - top;
                map[top] = diff;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            Integer top = stack.pop();
            map[top] = 0;
        }
        return map;
    }
}