class Solution {
    
    public int[] findOrder(int numCourses, int [][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        int[] taken = new int[numCourses];
        // build graph
        for (int i = 0; i < numCourses ; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //  add edge to the graph
        for(int [] course : prerequisites){
            taken[course[0]]++;
            graph.get(course[1]).add(course[0]);
        }
    return BFS(graph,taken);
    }
    public int [] BFS (List<List<Integer>> graph,int [] taken){
        Queue<Integer> queue = new LinkedList<>();
        int [] order = new int[taken.length];
        for (int i = 0; i < taken.length ; i++) {
            if (taken[i] ==0 ){
                queue.offer(i);
            }
        }
        int visited = 0;
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            order[visited++] =currentCourse;
            for (int prerequisiteCourse : graph.get(currentCourse)) {
                taken[prerequisiteCourse]--;
                if (taken[prerequisiteCourse] == 0){
                    queue.offer(prerequisiteCourse);
                }
            }
        }

return visited == taken.length ? order : new int[0];
    }
}