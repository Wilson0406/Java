class Solution {
    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; // Using the relationship between GCD and LCM
    }
    public long findLcm(int[] arr)
    {
        long lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long num1 = lcm;
            long num2 = arr[i];
            long gcd_val = gcd(num1, num2);
            lcm = (lcm * arr[i]) / gcd_val;
        }
        return lcm;
    }
    public long findGcd(int arr[], int n)
    {
        long result = arr[0];
        for (int element: arr){
            result = gcd(result, (long)element);

            if(result == 1)
            {
               return 1;
            }
        }

        return result;
    }
    public long gcd(long a, long b)
    {
        // Find Minimum of a and b
        long result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }
    public long maxScore(int[] nums) {
        long max = 0;
        int n = nums.length;
        if(nums.length == 1) {
            return (long)nums[0] * nums[0];
        }
        
        long overallGcd = findGcd(nums, n);
        long overallLcm = findLcm(nums);
        max = overallGcd * overallLcm;
        for(int i = 0; i < n; i++) {
            int[] newArray = new int[n - 1];
            for (int j = 0, k = 0; j < n; j++) {
                if (j != i) {
                    newArray[k++] = nums[j];
                }
            }
            
            // Calculate GCD and LCM of the new array
            long newGCD = findGcd(newArray, n - 1);
            long newLCM = findLcm(newArray);

            // Calculate the factor score
            long score = newGCD * newLCM;
            max = Math.max(max, score);
        }
        return max;
    }
}