class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        int max = 0;
        for(int entry : map.keySet()) {
            count += map.get(entry);
            max = Math.max(max, count);
            // if(count > 2) {
            //     map.put(start, map.get(start) - 1);
            //     map.put(end, map.get(end) + 1);
            //     return false;
            // }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */