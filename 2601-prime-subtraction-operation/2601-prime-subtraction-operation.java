class Solution {
    boolean[] prime = new boolean[1000];
    public void sieve() {
        prime[0] = false;
        prime[1] = false;
        Arrays.fill(prime, true);
        
        for(int i = 2; i * i < 1000; i++) {
            if(prime[i] == true) {
                for(int j = i * i; j < 1000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        sieve(); // populate true on the index which are prime
        
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                continue;
            }
            
            for(int p = 2; p < nums[i]; p++) {
                if(prime[p] == false) continue;
                
                if(nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }
            if(nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}