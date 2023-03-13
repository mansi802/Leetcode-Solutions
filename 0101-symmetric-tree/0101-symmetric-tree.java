/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        if(root.left==null && root.right !=null) return false;
        
        if(root.left!=null && root.right==null) return false;
        
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode tree1,TreeNode tree2){
        
        if(tree1==null && tree2==null) return true;
        
        return (tree1!=null && tree2!=null) && (tree1.val==tree2.val) && helper(tree1.left,tree2.right) && helper(tree1.right,tree2.left);
        
    }
}