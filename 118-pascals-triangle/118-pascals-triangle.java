class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pasc = new ArrayList<>();
        if(numRows <= 0)
            return pasc;
        
        for(int i = 0; i < numRows; i++) {
            List<Integer> inp = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j==0 || j==i)
                    inp.add(1);
                else
                    inp.add(pasc.get(i-1).get(j-1)+pasc.get(i-1).get(j));
            }
            pasc.add(inp);
        }
        return pasc;
    }
}