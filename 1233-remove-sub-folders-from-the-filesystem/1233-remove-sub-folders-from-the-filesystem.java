class Solution {
    // TC : O(length of folder * L* L) where L is the length of each folder
//     public List<String> removeSubfolders(String[] folder) {
//         List<String> ans = new ArrayList<>();
//         Set<String> set = new HashSet<>();
//         for(String s : folder) {
//             set.add(s);
//         }
        
//         for(String s : folder) {
//             String temp = s;
//             boolean subFolder = false;
//             while(!s.isEmpty()) {
//                 int pos = s.lastIndexOf('/');
//                 if (pos == -1) break;
//                 s = s.substring(0, pos);
//                 if(set.contains(s)) {
//                     subFolder = true;
//                     break;
//                 }
//             }
//             if(subFolder == false) {
//                 ans.add(temp);
//             }
//         }
//         return ans;
//     }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        
        for(int i = 1; i < folder.length; i++) {
            String currFolder = folder[i];
            String lastFolder = ans.get(ans.size() - 1);
            
            lastFolder += '/';
            if(!currFolder.startsWith(lastFolder)) {
                ans.add(currFolder);
            }
        }
        return ans;
    }
}