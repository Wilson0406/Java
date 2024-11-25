class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }
        String target = "123450";
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 3});
        map.put(1, new int[]{0, 2, 4});
        map.put(2, new int[]{1, 5});
        map.put(3, new int[]{0, 4});
        map.put(4, new int[]{1, 3, 5});
        map.put(5, new int[]{2, 4});
        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        
        Queue<String> q = new LinkedList<>();
        q.offer(start.toString());
        
        int level = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            
            while(n-- > 0) {
                String curr = q.poll();
                
                if(curr.equals(target)) return level;
                
                int zeroIdx = curr.indexOf('0');
                for(int idx : map.get(zeroIdx)) {
                    char[] sArray = curr.toCharArray();
                    char temp = sArray[zeroIdx];
                    sArray[zeroIdx] = sArray[idx];
                    sArray[idx] = temp;
                    
                    String newState = new String(sArray);
                    if(!visited.contains(newState)) {
                        q.add(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}