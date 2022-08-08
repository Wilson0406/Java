class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pasc = new ArrayList<>();
        // if(rowIndex <= 0)
        //     return pasc.get(0);
        
        for(int i = 0; i <= rowIndex; i++) {
            List<Integer> ans = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j==0 || j == i)
                    ans.add(1);
                else
                    ans.add(pasc.get(i-1).get(j-1)+pasc.get(i-1).get(j));
            }
            pasc.add(ans);    
        }
        return pasc.get(rowIndex);
    }
}