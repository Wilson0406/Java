class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str2+str1).equals(str1+str2)) return "";
        
        int gcdV = gcd(str2.length(), str1.length());
        return str2.substring(0,gcdV);
    }
    
    public int gcd(int p, int q) {
        if(q == 0) return p;
        
        return gcd(q, p % q);
    }
}