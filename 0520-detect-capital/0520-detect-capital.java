class Solution {
    public boolean detectCapitalUse(String word) {
        int cap = 0;
        // if(isUpperCase(word.charAt(0))) {
        //     cap++;
        // }
        
        for(int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                cap++;
            }
        }
        if(cap == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        if(cap == word.length()) {
            return true;
        }
        if(cap == 0) {
            return true;
        }
        return false;
    }
}