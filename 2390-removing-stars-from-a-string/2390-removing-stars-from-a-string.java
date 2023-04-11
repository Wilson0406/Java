// class Solution {
//     public String removeStars(String s) {
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if(ch == '*'){
//                 sb.deleteCharAt(sb.length()-1);
//             } else {
//                 sb.append(ch);
//             }
//         }
        
//         return sb.toString();
//     }
// }

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch == '*'){
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}