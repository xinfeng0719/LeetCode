/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        //label is unique, we can mark label as index in the hashmap
        HashMap<Integer,UndirectedGraphNode> record = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        record.put(node.label,clone);
        dfs(node,record);
        return clone;
        
    }
    public void dfs(UndirectedGraphNode node,HashMap<Integer,UndirectedGraphNode> record){
        UndirectedGraphNode curNode = record.get(node.label);
        for(UndirectedGraphNode neighbor:node.neighbors){
            UndirectedGraphNode curNeighbor = record.get(neighbor.label);
            if(curNeighbor==null){
                //don't add this before, copy this node, add to the record
                curNeighbor = new UndirectedGraphNode(neighbor.label);
                record.put(neighbor.label,curNeighbor);
                dfs(neighbor,record);
            }
            curNode.neighbors.add(curNeighbor);
        }
        
    }
}
