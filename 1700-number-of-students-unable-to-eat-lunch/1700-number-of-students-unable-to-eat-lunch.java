class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>();
        int top = 0;
        for(int i = 0; i < students.length; i++) {
            student.offer(students[i]);
        }
        int count = 0;
        while(!student.isEmpty() && count != student.size()) {
            if(student.element() == sandwiches[top]) {
                top++;
                count = 0;
                student.poll();
            } else {
                int s = student.poll();
                student.offer(s);
                count++;
            }
        }
        return student.size();
    }
}