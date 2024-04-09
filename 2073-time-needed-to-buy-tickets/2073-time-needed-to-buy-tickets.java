class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(tickets[i] <= tickets[k]) {
                count += tickets[i];
            } else {
                count += tickets[k];
            }
            if(i > k && tickets[i]>= tickets[k]) count--;
        }
        return count;
    }
}