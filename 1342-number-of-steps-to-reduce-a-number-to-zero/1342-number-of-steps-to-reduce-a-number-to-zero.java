// class Solution {
//     public int numberOfSteps(int num) {
//         int count = 0;
//         while (num > 0) {
//             if ((num&1) == 0) {
//                 num = num >> 1;
//                 count++;
//             }
//             else {
//                 num = num - 1;
//                 count++;
//             }
//         }
//         return count;
//     }
// }



// Using Recursion

class Solution {
    public int helper(int num, int count) {
        if(num == 0) 
            return count;
        if(num % 2 == 0) 
            return helper(num/2, count + 1);
        return helper(num - 1, count + 1);
    }
        
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
}