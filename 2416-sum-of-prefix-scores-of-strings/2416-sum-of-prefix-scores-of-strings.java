class Trie {
    int count = 0;
    Trie child[] = new Trie[26];
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        Trie trie = new Trie();
        int k = 0;
        for(String s : words) {
            Trie t = trie;
            for(char ch : s.toCharArray()) {
                int c = ch - 'a';
                if(t.child[c] == null) t.child[c] = new Trie();
                t.child[c].count++;
                t = t.child[c];
            }
        }
        
        for(String s : words) {
            Trie t = trie;
            int curr = 0;
            for(char ch : s.toCharArray()) {
                int c = ch - 'a';
                curr += t.child[c].count;
                t = t.child[c];
            }
            ans[k++] = curr;
        }
        return ans;
    }
}