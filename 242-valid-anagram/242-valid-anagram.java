class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        if(s.length() == 1 && t.length() == 1){
            if(s == t){
                return true;
            }
        }
        if(s.length() != t.length()){
            return false;
        }
        else{
            char temp1[] = s.toCharArray();
            char temp2[] = t.toCharArray();   
            Arrays.sort(temp1);
            Arrays.sort(temp2);
            return Arrays.equals(temp1,temp2);
        }
    }
    
}