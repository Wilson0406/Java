class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        
        // Sort based on which number coming first will create large value
        Arrays.sort(s, (a,b)->(b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for(String st : s) {
            sb.append(st);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}