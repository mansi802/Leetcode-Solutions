class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        dfs(rooms,visited,0);
        for(int i=0;i<n;i++)
            if(!visited[i]) 
                return false;
        
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms,boolean[] visited,int i){
        visited[i]=true;
        
        for(int j:rooms.get(i)){
            if(!visited[j])
                dfs(rooms,visited,j);
        }
    }
}