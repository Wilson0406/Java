class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pset = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nset = new HashSet<>(Arrays.asList(negative_feedback));
        
        List<Integer> ans = new ArrayList<>();
        
        int[][] arr2 = new int[report.length][2];
        for(int i = 0; i < report.length; i++) {
            int score = 0;
            String[] rep = report[i].split(" ");
            for(String x : rep) {
                if(pset.contains(x)) {
                    score += 3;
                } else if(nset.contains(x)) {
                    score--;
                }
            }
            arr2[i][0] = student_id[i];
            arr2[i][1] = score;
        }
        
        Arrays.sort(arr2, (a,b) -> a[1] == b[1]? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]));
        
        for(int i = 0; i < k; i++) {
            ans.add(arr2[i][0]);
        }
        return ans;
    }
}