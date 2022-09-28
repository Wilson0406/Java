import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));
        // Frequency count of each number
        for(int n : nums) {
                count.put(n, count.getOrDefault(n,0)+1);
        }
        
        // Priority Queue storing top k elements
        for(int j: count.keySet()) {
            max.add(j);
            if(max.size() > k) {
                max.poll();
            }
        }
        int[] ar = new int[k];
        int i = 0;
        while(!max.isEmpty()) {
            ar[i++] = max.poll();
        }
        return ar;
    }
}