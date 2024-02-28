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
    int max=0,result=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        fill(root,0);
        return result;
    }
    
    private void fill(TreeNode root,int level){
        if(root==null) return ;
        
        if(level>max){
            max=level;
            result=root.val;
        }
        
        fill(root.left,level+1);
        fill(root.right,level+1);
    }
}