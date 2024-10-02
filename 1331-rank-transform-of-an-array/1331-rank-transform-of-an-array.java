class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int temp[] = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < temp.length; i++) {
            if(map.containsKey(temp[i])) {
                // rank -= 1;
                continue;
            }
            map.put(temp[i], rank++);
            // rank += 1;
        }
        for(int i = 0; i < arr.length; i++) {
            temp[i] = map.get(arr[i]);
        }
        return temp;
    }
}