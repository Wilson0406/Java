class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < len; i++) {
            if(list.contains(s.charAt(left))) {
                if(list.contains(s.charAt(right))) {
                    char ch = s.charAt(left);
                    sb.setCharAt(left,s.charAt(right));
                    sb.setCharAt(right,ch);
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return sb.toString();
    }
}