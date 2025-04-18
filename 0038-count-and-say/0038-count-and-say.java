class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if(n == 1) return "1";
        while(n-- > 1) {
            // System.out.println(s);
            Queue<int[]> q = new LinkedList<>();
            char ch = s.charAt(0);
            int count = 1;
            for(int i = 1; i < s.length(); i++) {
                if(ch == s.charAt(i)) {
                    count++;
                } else {
                    q.offer(new int[]{ch - '0', count});
                    count = 1;
                    ch = s.charAt(i);
                }
            }
            q.offer(new int[]{s.charAt(s.length() - 1) - '0', count});
            String t = "";
            while(!q.isEmpty()) {
                int[] temp = q.poll();
                t += Integer.toString(temp[1]);
                t += Integer.toString(temp[0]);
            }
            s = t;
        }
        return s;
    }
}