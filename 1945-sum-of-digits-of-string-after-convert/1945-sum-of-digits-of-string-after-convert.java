class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        for(char c : s.toCharArray()) {
            str += (c - 'a' + 1);
        }
        System.out.println(str);
        
        while(k-- > 0) {
            int sum = 0;
            for(char c : str.toCharArray()) {
                sum += c - '0';
            }
            str = Integer.toString(sum);
        }
        
        return Integer.parseInt(str);
    }
}