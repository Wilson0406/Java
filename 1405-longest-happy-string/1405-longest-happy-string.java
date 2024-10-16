class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0] - x[0]);
        
        if(a > 0) pq.offer(new int[]{a, 'a'});
        if(b > 0) pq.offer(new int[]{b, 'b'});
        if(c > 0) pq.offer(new int[]{c, 'c'});
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            char currChar = (char)curr[1];
            int currCount = curr[0];
            
            // Check if the last two characters are same as the current character
            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == currChar && sb.charAt(sb.length() - 2) == currChar) {
                
                if(pq.isEmpty()) break;
                
                // Use the next most frequent character
                int next[] = pq.poll();
                char nextChar = (char)next[1];
                int nextCount = next[0];
                
                sb.append(nextChar);
                nextCount--;
                
                if(nextCount > 0) {
                    pq.offer(new int[]{nextCount, nextChar});
                }
                // push the current character back in queue
                pq.offer(curr);
            } else {
                // use current character
                sb.append(currChar);
                currCount--;
                if(currCount > 0) {
                    pq.offer(new int[]{currCount, currChar});
                }
            }
        }
        
        return sb.toString();
    }
}