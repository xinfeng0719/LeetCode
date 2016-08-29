public class Solution {
    //global boolean for whether we can have result
    boolean impossible=false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //as we want to know the order, the easier way is using a Stack,then we can have the result by poping the stack
        Stack<Integer> stack = new Stack<Integer>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] path = new int[numCourses];//determine whether or not cycle exist, after we touch one class, set a value, once we goes that value again, in dfs we shall return//1 for visited, 2 for not visited
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            dfs(stack,graph,path,i);
            if(impossible){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for(int i=numCourses-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
    private void dfs(Stack<Integer> stack, List<List<Integer>> graph,int[] path,int course){
        if(path[course]==2||impossible){
            return;//cycle exist because cycle exist
        }
        if(path[course]==1){
            impossible=true;
            return;//
        }
        path[course]=1;
        for(int nextCourse:graph.get(course)){
            dfs(stack,graph,path,nextCourse);
            if(impossible){
                return;
            }
        }
        stack.push(course);//we will first push the required class before, but it exist calss that we can put anywhere
        path[course]=2;//after exploration
    }
}
