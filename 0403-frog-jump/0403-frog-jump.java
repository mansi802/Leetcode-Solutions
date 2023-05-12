class Solution {
    public boolean canCross(int[] stones) {
        int N = stones.length;
        boolean[][] dp=new boolean[N][N+1];
        dp[0][1] = true;
        
        for(int i = 1; i < N; ++i){
            for(int j = 0; j < i; ++j){
                int diff = stones[i] - stones[j];
                if(diff > N || !dp[j][diff]) 
                    continue;
                
                if(i == N - 1) 
                    return true;
                
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 <= N) dp[i][diff + 1] = true;
            }
        }

        return false;
    }
    
    
    private boolean helper(int i,int jumps,int[] stones){
        if(i==stones.length-1)
            return true;
            
        boolean ans=false;
        for(int ind=i+1; ind<stones.length; ind++){
            if(stones[ind]-stones[i]>jumps+1)
                break;
            for(int t=-1; t<2; t++){
                if(stones[ind]-stones[i]==jumps+t)
                    ans = helper(ind, jumps+t, stones) || ans;
            }
        }
    
        return ans;
    }
}