class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(2*arr[i]) && arr[i] != 0) {
                // System.out.println(2*arr[i]);
                return true;
            }
            if(arr[i] == 0 && map.get(arr[i]) > 1) {
                // System.out.println(arr[i]);
                return true;
            }

        }
        return false;
    }
}