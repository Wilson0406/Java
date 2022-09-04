class Solution {
    public boolean checkDistances(String s, int[] distance) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
        int dist = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(list.get(ch-'a') != -1){
                if((i - list.get(ch-'a') - 1) != (distance[ch-'a']))
                    return false;
            }
            else {
                list.set(ch-'a',i);
            }
        }
        return true;
    }
}