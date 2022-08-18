class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        int []freq = new int[map.values().size()];
        int i = 0;
        for(int fre: map.values())
            freq[i++] = fre;
        
        Arrays.sort(freq);
        i = freq.length - 1;
        int remove = 0;
        while(remove < len/2) {
            count++;
            remove += freq[i--];
        }
        return count;
    }
}