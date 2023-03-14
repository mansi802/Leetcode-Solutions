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
    int result=0;
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return result;
    }
    
    private void solve(TreeNode root,int curr){
        if(root==null) return;
        
        if(root.left==null && root.right==null){
            result+=curr*10+root.val;
            return;
        }
        
        solve(root.left,curr*10+root.val);
        solve(root.right,curr*10+root.val);
    }
}