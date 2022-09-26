class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [0,1] => [v,u]
        // 1 -> 0
        // u -> v
       int [] taken = new int [numCourses];
        // new graph
       List<List<Integer>> graph = new ArrayList<>();
       for(int i =0 ; i < numCourses;i++){
           graph.add(new ArrayList<Integer>());
       }
        
        // add edge to graph
       for(int [] edge : prerequisites) {
           graph.get(edge[0]).add(edge[1]);
       }
        
       for(int i = 0 ; i < numCourses; i++){
           if(dfs(graph,taken, i)){
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