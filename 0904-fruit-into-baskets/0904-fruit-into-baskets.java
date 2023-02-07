class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for(j = 0; j < fruits.length; j++) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            if(count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                count.remove(fruits[i++], 0);
            }
        }
        return j - i;
    }
}