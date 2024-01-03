class Solution {
    public int beams(List<Integer> bank) {
        if(bank.size() == 1) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < bank.size() - 1; i++) {
            sum += bank.get(i) * bank.get(i + 1);
        }
        return sum;
    }
    public int numberOfBeams(String[] bank) {
        List<Integer> arr = new ArrayList<>();
        for(String b : bank) {
            int count = 0;
            for(int i = 0; i < b.length(); i++) {
                if(b.charAt(i) == '1') {
                    count++;
                }
            }
            if(count > 0) {
                arr.add(count);
            }
        }
        return beams(arr);
    }
}