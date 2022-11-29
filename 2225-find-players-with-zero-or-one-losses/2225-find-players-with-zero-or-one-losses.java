class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> zero = new HashSet<>(), one = new HashSet<>(), more = new HashSet<>();
        
        for(int[] match: matches) {
            int winner = match[0], loser = match[1];
            
            // Add winner
            if(!one.contains(winner) && !more.contains(winner)) {
                zero.add(winner);
            }
            
            // Add or move loser
            if(zero.contains(loser)) {
                zero.remove(loser);
                one.add(loser);
            } else if(one.contains(loser)) {
                one.remove(loser);
                more.add(loser);
            } else if(more.contains(loser)) {
                continue;
            } else {
                one.add(loser);
            }
        }
        List<List<Integer>> ans= Arrays.asList(new ArrayList<>(), new ArrayList<>());
        ans.get(0).addAll(zero);
        ans.get(1).addAll(one);
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}