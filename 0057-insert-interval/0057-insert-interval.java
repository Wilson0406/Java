class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        
        int i = 0, n = intervals.length;
        
        // add all intervals that are non-everlapping
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        
        // merge newInterval with the overlapping interval
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        list.add(newInterval);
        
        // add all the remaining intervals
        while(i < n) {
            list.add(intervals[i++]);
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}