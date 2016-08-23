//LCA in BST is much easier. LCA'a val shall be in the range of TreeNode p and TreeNode q
//the first method is directly, we need a method determining whether Node p is the parent of given node
//we go down from p's direction, every level we determine whether this node is q's parent and update the current lowest node
//after we are finished this process, we find the LCA
//the corner case is node p is the LCA(so need one more determination before return 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode LCA = root;
        TreeNode parent;
        if(p!=root){
            parent=root.val<p.val?root.right:root.left;
        }else{
            parent=root;
        }
        while(parent!=p){
            if(isParent(parent,q)){
                LCA=parent;
            }
            //if parent is q's parent, we goes lower to p's direction, the first node that wasn't q's parent
            parent=parent.val<p.val?parent.right:parent.left;
        }
        if(isParent(parent,q)){
            LCA=parent;
        }
        return LCA;
    }
    public boolean isParent(TreeNode root, TreeNode given){
        while(root!=null){
            if(root==given){
                return true;
            }
            root = root.val<given.val?root.right:root.left;
        }
        return false;
    }
}

//the second method using recurisve, we lower the node from root, until we find the val in between two origin node val
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}
