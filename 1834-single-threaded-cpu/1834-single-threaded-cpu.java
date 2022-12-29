class Solution {
    class Task {
        int index;
        int enqueueTime;
        int processingTime;
        Task(int index, int en, int pr) {
            this.index = index;
            this.enqueueTime = en;
            this.processingTime = pr;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        
        Arrays.sort(arr, (a,b) -> {
            return Integer.compare(a.enqueueTime, b.enqueueTime);
        });
        
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            if(a.processingTime == b.processingTime) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        });
        
        int ansIndex = 0;
        int taskIndex = 0;
        int currTime = 0;
        int[] ans = new int[n];
        
        while(ansIndex < n) {
            while(taskIndex < n && arr[taskIndex].enqueueTime <= currTime) {
                pq.offer(arr[taskIndex++]);
            }
            
            if(pq.isEmpty()) {
                currTime = arr[taskIndex].enqueueTime;
            } else {
                currTime += pq.peek().processingTime;
                ans[ansIndex++] = pq.poll().index;
            }
        }
        return ans;
    }
}