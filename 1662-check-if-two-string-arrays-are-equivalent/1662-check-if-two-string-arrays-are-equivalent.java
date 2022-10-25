class Solution {
//     public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//         //String str1 = String.copyValueOf(word1);
//         //String str2 = String.copyValueOf(word2);
//         String str1 = Arrays.toString(word1);
//         String str2 = Arrays.toString(word2);
        
//         if(str1.equals(str2)){
//             return true;
//         }
//         else{
//             return false;
//            }
//     }
// }
    
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    
            StringBuffer sb1 = new StringBuffer();
              for(int i = 0; i < word1.length; i++) {
                 sb1.append(word1[i]);
              }
            String str1 = sb1.toString();
            
            StringBuffer sb2 = new StringBuffer();
            for(int i = 0; i < word2.length; i++) {
                 sb2.append(word2[i]);
              }
            String str2 = sb2.toString();
            
            if(str1.equals(str2)){
                return true;
            }
            else {
                return false;
            }
         }
    }


