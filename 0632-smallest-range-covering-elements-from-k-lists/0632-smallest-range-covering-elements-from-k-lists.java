class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[]{-1000000,1000000};
        int k = nums.size();
        int[] k_list = new int[k];
        while(true) {
            int minEl = Integer.MAX_VALUE, maxEl = Integer.MIN_VALUE, minInd = 0;

            for(int i = 0; i < k; i++) {
                int listIndex = i;
                int elementIndex = k_list[i];
                int element = nums.get(i).get(elementIndex);

                if(element < minEl) {
                    minEl = element;
                    minInd = listIndex;
                }

                maxEl = Math.max(maxEl, element);
            }
                // Range
                if(maxEl - minEl < res[1] - res[0]) {
                    res[1] = maxEl;
                    res[0] = minEl;
                }

                // Shorted the range
                int nextIndex = k_list[minInd] + 1;
                if(nextIndex >= nums.get(minInd).size()) {
                    break;
                }

                k_list[minInd] = nextIndex;
        }
        
        return res;
    }
}