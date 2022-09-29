class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> max = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        String ans = "";
        for(Character ch : map.keySet()) {
            max.add(ch);
        }
        
        while(!max.isEmpty()) {
            char ch = max.poll();
            while(map.get(ch) != 0) {
                ans += ch;
                map.put(ch, map.get(ch) - 1);
            }
        }
        return ans;
    }
}