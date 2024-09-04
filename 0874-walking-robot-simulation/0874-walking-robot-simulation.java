class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int[] curPos = {0, 0};
        // North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0; // North
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] obstacle : obstacles) {
            if(!map.containsKey(obstacle[0])) {
                map.put(obstacle[0], new HashSet<>());
            }
            map.get(obstacle[0]).add(obstacle[1]);
        }
        
        for(int command: commands) {
            if(command == -1) {
                curDir = (curDir + 1) % 4;
            }
            if(command == -2) {
                curDir = (curDir - 1);
                if(curDir == -1) curDir = 3;
            }
            
            int[] direction = directions[curDir];
            for(int step = 0; step < command; step++) {
                int nextX = curPos[0] + direction[0];
                int nextY = curPos[1] + direction[1];
                if(map.containsKey(nextX) && map.get(nextX).contains(nextY)) {
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }
            res = Math.max(res, curPos[0] * curPos[0] + curPos[1] * curPos[1]);
        }
        return res;
    }
}