
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new ArrayDeque<>();
        
        q.add(new Pair(root,0));
        
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int first=0,last=0;
            int min=q.peek().id;
            for(int i=0;i<size;i++){
                Pair top=q.remove();
                TreeNode node=top.root;
                int id=top.id-min;
                
                if(i==0) first=id;
                if(i==size-1) last=id;
                
                if(node.left!=null) q.offer(new Pair(node.left,id*2+1));
                
                if(node.right!=null) q.offer(new Pair(node.right,id*2+2));
            }
            
            ans=Math.max(ans,last-first+1);
        }
        
        return ans;
        
    }
}

class Pair{
    TreeNode root;
    int id;
    
    Pair(TreeNode root,int id){
        this.root=root;
        this.id=id;
    }
}