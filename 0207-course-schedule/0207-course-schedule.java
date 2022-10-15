class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int [] taken = new int [numCourses];
        // new graph
       List<List<Integer>> graph = new ArrayList<>();
        // build the graph
       for(int i =0 ; i < numCourses;i++){
           graph.add(new ArrayList<Integer>());
       }
        // add edge to graph
       for(int [] edge : prerequisites) {
           graph.get(edge[0]).add(edge[1]);
       }
        // build the graph (done)
       for(int i = 0 ; i < numCourses; i++){
           if( dfs(graph,taken, i)){
               return false;
           }
       }
        return true;
    }
    
    public boolean dfs (List<List<Integer>> graph, int taken[],int vertice){
        if(taken[vertice] == 1) return true;
        if(taken[vertice] == 2) return false;
        taken[vertice] = 1;
        for(int adj : graph.get(vertice)){
            if(dfs(graph,taken,adj)) return true;
        }
        taken[vertice] = 2;
        return false;
    }
}