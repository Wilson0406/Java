class Solution {
    boolean visited[];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        
        dfs(rooms, 0);
        for(boolean ch: visited)
            if(!ch)
                return false;
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int index) {
        for(int i : rooms.get(index)) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(rooms, i);
            }
        }
    }
}