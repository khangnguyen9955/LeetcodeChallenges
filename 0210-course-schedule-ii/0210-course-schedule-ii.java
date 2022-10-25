class Solution {
    
    public int[] findOrder(int numCourses, int [][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        int[] totalPreCoursesOfEachCourse = new int[numCourses];
        // build graph
        for (int i = 0; i < numCourses ; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //  add edge to the graph
        //  
        // different with the course schedule problem
        // this problem we will build the graph with index is the course and value is other available courses can take from this course
        // and we also count the total prerequisite courses of a course
        // we can take
        for(int [] course : prerequisites){
            totalPreCoursesOfEachCourse[course[0]]++;
            graph.get(course[1]).add(course[0]);
        }
        // with example 2
        // Course | Available 
        //  0     | [1,2]
        //  1     | [3]
        //  2     | [3]
    return BFS(graph,totalPreCoursesOfEachCourse);
    }
    public int [] BFS (List<List<Integer>> graph,int []totalPreCoursesOfEachCourse){
        Queue<Integer> queue = new LinkedList<>();
        int numCourse = totalPreCoursesOfEachCourse.length; 
        int [] order = new int[numCourse];
        for (int i = 0; i < numCourse ; i++) {
            if (totalPreCoursesOfEachCourse[i] == 0 ){ 
                queue.offer(i); 
                // we will add all the courses that do not
                // need us to take any prequisite courses to the queue
            }
        }
        int visited = 0; // for counting
        while(!queue.isEmpty()){
            int currentCourse = queue.poll(); 
            // from this current course
            order[visited++] = currentCourse;
            for (int availableCourse: graph.get(currentCourse)) {
            // get all the course we can take  
            // from the current course
            totalPreCoursesOfEachCourse[availableCourse]--;
            // we will decrease the total prerequisite course of this current course
            // by 1, because we will offer it into the queue now and BFS it
                if (totalPreCoursesOfEachCourse[availableCourse] == 0){
                    // if this total pre... course of this current course
                    // now become 0, it means that we have to take 
                    // this available course after the current course
                    // for example course 0 -> course 1
                    queue.offer(availableCourse);
                    // now we will add this available course to the queue to BFS
                }
                // if the total... of available course 
                // not equal 0, so this available course can be taken after
                // another course, so we just continue loop
                // and this available course will be taken after
                // the last course (in graph) 
            }
        }
return visited == numCourse ? order : new int[0];
    }
}