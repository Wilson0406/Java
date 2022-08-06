class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int copy[] = Arrays.copyOfRange(candies, 0, candies.length);
        Arrays.sort(copy);
        int max = copy[copy.length - 1];
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            if((candies[i] + extraCandies) >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}