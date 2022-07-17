class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(" ")){
            return true;
        }
        if(s.length()==0){
            return false;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int second= s.length() - 1;
        int first = 0;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(first++)!=s.charAt(second--)){
                return false;
            }
        }
        return true;
    }
}