class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        int index = 0, incre = 1;
        for(int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if(index == 0) incre = 1;
            if(index == numRows - 1) incre = -1;
            index += incre;
        }
        
        String ans = "";
        for(int i = 0; i < numRows; i++) {
            ans += sb[i];
        }
        return ans.toString();
    }
}