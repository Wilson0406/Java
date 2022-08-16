class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();
        int len = s.length();
        pq.add(-1);
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1)
                return i;
        }
        return -1;
    }
}