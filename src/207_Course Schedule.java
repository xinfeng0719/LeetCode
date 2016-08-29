public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];//store the possible pre requiqre chain for Course n
        int[] visited = new int[numCourses];//-1 visited, 1 not visited
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]); //initial the graph
        }
        //Main process is while we are looking at class s, we will set all its pre require class to "boolean" parameter
        //once we found that we had a circle,we will return false.
        for(int i=0;i<numCourses;i++){
            if(dfs(graph,visited,i)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(ArrayList[] graph,int[] visited,int course){
        if(visited[course]==-1){
            return true;
        }
        if(visited[course]==1){
            return false;
        }
        visited[course]=-1;//visited this course
        for(int i=0;i<graph[course].size();i++){
            if(dfs(graph,visited,(int)graph[course].get(i))){
                return true;
            }
        }
        visited[course]=1;
        return false;
    }
}
