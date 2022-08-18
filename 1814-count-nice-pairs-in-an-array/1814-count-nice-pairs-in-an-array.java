class Solution {
    public int rev(int x) {
        int reverse = 0;
        while(x != 0) {
            int temp = x%10;
            reverse = reverse*10 + temp;
            x = x/10;
        }
        return reverse;
    }
    public int countNicePairs(int[] nums) {
        int count = 0;
        int key;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            key = nums[i] - rev(nums[i]);
            if(map.containsKey(key))
                count = (count + map.get(key))%1000000007;
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        return count;
    }
}