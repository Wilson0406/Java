class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long sum = skill[0] + skill[n-1];
        long ans = 0L;
        for(int i = 0; i <n/2; i++) {
            if(sum == (skill[i] + skill[n-1-i])) {
                ans += skill[i]*skill[n-1-i];
                continue;
            } else {
                return -1;
            }
        }
        return ans;
    }
}