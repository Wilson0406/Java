// class Solution {
//     public boolean checkIfPangram(String sentence) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < sentence.length(); i++) {
//             char ch = sentence.charAt(i);
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//         if(map.size() > 25) {
//             return true;
//         }
//         return false;
//     }
// }


class Solution {
    public boolean checkIfPangram(String sentence) {
        return sentence.chars().distinct().count() == 26;
    }
}