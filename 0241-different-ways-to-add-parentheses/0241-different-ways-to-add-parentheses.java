class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if(c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                List<Integer> l = map.getOrDefault(left, diffWaysToCompute(left));
                List<Integer> r = map.getOrDefault(right, diffWaysToCompute(right));
                
                for(int n1 : l) {
                    for(int n2 : r) {
                        if(c == '+') {
                            res.add(n1 + n2);
                        } else if(c == '-') {
                            res.add(n1 - n2);
                        } else if(c == '*') {
                            res.add(n1 * n2);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        map.put(expression, res);
        
        return res;
    }
}