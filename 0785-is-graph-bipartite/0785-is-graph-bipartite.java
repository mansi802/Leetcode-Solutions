class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        
        for(int i=0;i<n;i++){
            if(color[i]==0)
                if(!check(graph,color,i)) return false;
        }
        
        return true; 
    }
     
    //using DFS
    private boolean check(int[][] graph,int[] color,int i){
        if(color[i]==0)
            color[i]=1;
        
        for(int j:graph[i]){
            if(color[j]==0){
                color[j]=color[i]==1?2:1;
                if(!check(graph,color,j)) return false;
            }else if(color[i]==color[j]) return false;
        }
        
        return true;
    }
}