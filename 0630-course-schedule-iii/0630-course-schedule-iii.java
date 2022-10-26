public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]); 
        // sort the deadlines
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int currentDays = 0;
        for (int[] course:courses) 
        {
            currentDays+=course[0]; // add the cost days of this course
            pq.add(course[0]);
            if (currentDays>course[1])  
                // if the currentDays is exceeded the deadline of this course
            {
                // we will remove the longest course in the queue
                // which is in the front of the priority queue
                currentDays-=pq.poll(); 
            }
        }        
        return pq.size();
    }
}