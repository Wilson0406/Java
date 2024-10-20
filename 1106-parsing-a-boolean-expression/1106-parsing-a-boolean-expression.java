class Solution {
    int index = 0;
    public boolean evaluate(String e) {
        char curr = e.charAt(index++);
        
        if(curr == 't') return true;
        if(curr == 'f') return false;
        
        if(curr == '!') {
            index++;
            boolean res = !evaluate(e);
            index++;
            return res;
        }
        
        // Handle & and |
        List<Boolean> children = new ArrayList<>();
        index++;
        while(e.charAt(index) != ')') {
            if(e.charAt(index) != ',') {
                children.add(evaluate(e));                
            } else {
                index++; // skip coma
            }
        }
        index++; // skip ')'
        
        if(curr == '&') {
            for(Boolean c : children) {
                if(!c) return false;// if any value is false return false
            }
            return true;
        }
        if(curr == '|') {
            for(Boolean c : children) {
                if(c) return true;// if any value is false return false
            }
            return false;
        }
        
        return false;
    }
    public boolean parseBoolExpr(String expression) {
        return evaluate(expression);
    }
}