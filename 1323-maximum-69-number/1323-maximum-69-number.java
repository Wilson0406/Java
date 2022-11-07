class Solution {
    public int maximum69Number (int num) {
        String temp = Integer.toString(num);
        int[] arr = new int[temp.length()];
        for(int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - '0';
        }
        int check = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 6) {
                arr[i] = 9;
                break;
            }
        }
        for(int ar: arr) {
            check = 10 * check + ar;
        }
        return check;
    }
}