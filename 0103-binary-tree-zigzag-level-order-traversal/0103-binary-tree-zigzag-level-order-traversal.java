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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        fill(result,root,0);
        return result;
        
    }
    
    private void fill(List<List<Integer>> result,TreeNode root,int level){
        if(root==null) return;
        
        if(level>=result.size()){
            result.add(new ArrayList<>());
        }
        
        List<Integer> list=result.get(level);
        if(level%2==0)
            list.add(root.val);
        else
            list.add(0,root.val);
        
        fill(result,root.left,level+1);
        fill(result,root.right,level+1);
    }
}