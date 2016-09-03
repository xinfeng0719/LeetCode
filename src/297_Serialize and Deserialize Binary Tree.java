/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        //like LeetCode,1/2,3/null null 4 5//this format
        //like bfs
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur==null){
                sb.append("null");
            }else{
                sb.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            sb.append(",");//seperate by ','
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] node = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(node[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while(i<node.length){
            TreeNode cur = queue.poll();
            String left = node[i];
            String right = node[i+1];
            if(!left.equals("null")){
                TreeNode leftNode = new TreeNode(Integer.valueOf(left));
                cur.left = leftNode;
                queue.add(leftNode);
            }else{
                cur.left=null;
            }
            if(!right.equals("null")){
                TreeNode rightNode = new TreeNode(Integer.valueOf(right));
                cur.right = rightNode;
                queue.add(rightNode);
            }else{
                cur.right=null;
            }
            i+=2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
