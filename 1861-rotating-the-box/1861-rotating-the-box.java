class Solution {
    public char[] reverseRow(char[] row) {
        int s = 0, e = row.length - 1;
        while(s < e) {
            char temp = row[s];
            row[s] = row[e];
            row[e] = temp;
            s++;
            e--;
        }
        return row;
    }
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        
        // transpose
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[j][i] = box[i][j];
            }
        }
        
        // reverse row
        for(int i = 0; i < n; i++) {
            ans[i] = reverseRow(ans[i]);
        }
        
        // apply gravity
        // for(int j = 0; j < m; j++) {
        //     for(int i = n - 1; i >= 0; i--) {
        //         if(ans[i][j] == '.') {
        //             int stoneRow = -1;
        //             for(int k = i - 1; k >= 0; k--) {
        //                 if(ans[k][j] == '*') break;
        //                 else if(ans[k][j] == '#') {
        //                     stoneRow = k;
        //                     break;
        //                 }
        //             }
        //             if(stoneRow != -1) {
        //                 ans[i][j] = '#';
        //                 ans[stoneRow][j] = '.';
        //             }
        //         }
        //     }
        // }
        
        for(int j = 0; j < m; j++) {
            int spaceRow = n - 1;
            for(int i = n - 1; i >= 0; i--) {
                if(ans[i][j] == '*') {
                    spaceRow = i - 1;
                    continue;
                }
                if(ans[i][j] == '#') {
                    ans[i][j] = '.';
                    ans[spaceRow][j] = '#';
                    spaceRow--;
                }
            }
        }
        
        return ans;
    }
}