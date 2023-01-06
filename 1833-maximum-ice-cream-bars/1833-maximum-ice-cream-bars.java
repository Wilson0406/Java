class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if(costs[0] > coins) {
            return 0;
        }
        int count = 0, i = 0;
        while(coins > 0 && i < costs.length) {
            coins -= costs[i++];
            count++;
            if(coins < 0) {
                count--;
            }
        }
        return count;
    }
}

// [7,3,3,6,6,6,10,5,9,2]
// [2,3,3,5,6,6,6,7,9,10]
// 56