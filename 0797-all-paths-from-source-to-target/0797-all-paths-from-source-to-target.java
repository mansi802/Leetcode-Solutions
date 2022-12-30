class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result=new ArrayList<>();
        
        if(graph.length==0) return result;
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,graph.length-1,path);
        return result;
    }
    
    private void dfs(int[][] graph,int src,int dest,List<Integer> path){
        if(src==dest){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i:graph[src]){
            path.add(i);
            dfs(graph,i,dest,path);
            path.remove(path.size()-1);
        }
    }
}