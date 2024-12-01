class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0 && map.containsKey(2 * arr[i])) {
                // System.out.println(arr[i]);
                return true;
            }
            if(arr[i] == 0 && map.get(arr[i]) > 1) return true;
        }
        return false;
    }
}