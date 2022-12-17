class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));
        int count = 0;
        int left = 0;
        int right = 1;
        int n = intervals.length;
        while(right < n) {
            if(intervals[left][1] <= intervals[right][0]) { // non overlap
                left = right;
                right++;
            } else if(intervals[left][1] <= intervals[right][1]) { // remove right interval
                count++;
                right++;
            } else if(intervals[left][1] > intervals[right][1]) { // remove left interval
                left = right;
                count++;
                right++;
            }
        }
            
        return count;
    }
}