class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
            // Brute force TC: O(nk)
//         int[] res = new int[]{-1000000,1000000};
//         int k = nums.size();
//         int[] k_list = new int[k];
//         while(true) {
//             int minEl = Integer.MAX_VALUE, maxEl = Integer.MIN_VALUE, minInd = 0;

//             for(int i = 0; i < k; i++) {
//                 int listIndex = i;
//                 int elementIndex = k_list[i];
//                 int element = nums.get(i).get(elementIndex);

//                 if(element < minEl) {
//                     minEl = element;
//                     minInd = listIndex;
//                 }

//                 maxEl = Math.max(maxEl, element);
//             }
//                 // Range
//                 if(maxEl - minEl < res[1] - res[0]) {
//                     res[1] = maxEl;
//                     res[0] = minEl;
//                 }

//                 // Shorted the range
//                 int nextIndex = k_list[minInd] + 1;
//                 if(nextIndex >= nums.get(minInd).size()) {
//                     break;
//                 }

//                 k_list[minInd] = nextIndex;
//         }
        
//         return res;
        
        // Using min-heap
        int[] res = {-1000000,1000000};
        int k = nums.size();
        
        // element, listIndex, elementIndex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int maxEl = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i , 0});
            maxEl = Math.max(maxEl, nums.get(i).get(0));
        }
        
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int minEl = curr[0];
            int listInd = curr[1];
            int elInd = curr[2];
            
            // Update range
            if(maxEl - minEl < res[1] - res[0]) {
                res[1] = maxEl;
                res[0] = minEl;
            }
            
            // Try to move to the next element in the list that contained the minimum element
            if(elInd + 1 < nums.get(listInd).size()) {
                int nextElement = nums.get(listInd).get(elInd + 1);
                pq.offer(new int[]{nextElement, listInd, elInd + 1});
                maxEl = Math.max(maxEl, nextElement);
            } else {
                break; // list exhausted
            }
        }
        return res;
    }
}