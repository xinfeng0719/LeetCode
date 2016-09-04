public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer,Node> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new Node(i));
        }
        for(int[] edge:edges){
            graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
            graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
            graph.get(edge[0]).degree++;
            graph.get(edge[1]).degree++;
        }
        Queue<Node> queue = new LinkedList<>();
        //put the node of degree one into the queue
        for(int index:graph.keySet()){
            if(graph.get(index).degree==1){
                queue.offer(graph.get(index));
            }
        }
        //as we know, there will be at most 
        while(n>2){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node leaf = queue.poll();
                Node neighbor = leaf.neighbors.iterator().next();
                neighbor.neighbors.remove(leaf);
                graph.remove(leaf.label);
                n--;
                if(--neighbor.degree==1){
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(graph.keySet());
    }
    class Node{
        int label;
        int degree;
        Set<Node> neighbors;
        public Node(int index){
            label = index;
            neighbors = new HashSet<>();
        }
    }
}
