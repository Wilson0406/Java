class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() < sentence2.length()) {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        
        String []s1 = sentence1.split(" ");
        String []s2 = sentence2.split(" ");
        
        int i = 0, j = s1.length - 1, k = 0, l = s2.length - 1;
        
        while(i < s1.length && k < s2.length && s1[i].equals(s2[k])) {
            k++;
            i++;
        }
        
        while(l >= k && s2[l].equals(s1[j])) {
            l--;
            j--;
        }
        return l < k;
    }
}