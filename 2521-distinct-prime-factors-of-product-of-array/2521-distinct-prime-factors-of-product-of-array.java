class Solution {
    public void factors(int n, Set<Integer> set) {
        while(n % 2 == 0) {
            set.add(2);
            n /= 2;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            while(n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if(n > 2) {
            set.add(n);
        }
        // return;
    }
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            factors(nums[i], set);
        }
        
        return set.size();
    }
}