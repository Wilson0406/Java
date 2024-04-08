class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                q.add(0);
                q.add(0);
            } else {
                q.add(arr[i]);
            }
            int top = q.poll();
            arr[i] = top;
        }
    }
}