// class MyCalendar {
//     List<int[]> calendar;
//     public MyCalendar() {
//         calendar = new ArrayList<>();
//     }
    
//     public boolean book(int start, int end) {
//         for(int[] iv : calendar) {
//             if(iv[0] < end && start < iv[1]) return false;
//         }
//         calendar.add(new int[]{start, end});
//         return true;
//     }
// }
class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int count = 0;
        for(int k : calendar.keySet()) {
            count += calendar.get(k);
            
            if(count > 1) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                return false;
                
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */