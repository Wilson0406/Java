class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < gifts.length; i++) {
            pq.offer(gifts[i]);
            // System.out.println(gifts[i]);
        }
        
        while(k-- > 0) {
            int curr = pq.poll();
            // System.out.println(curr);
            pq.add((int)Math.sqrt(curr));
            
        }
        long ans = 0;
        for(int val : pq) {
            ans += val;
        }
        return ans;
    }
}