class Solution {
    public int coinChange(int[] coins, int target) {
        int n=coins.length;
        
        int[][] memo=new int[n+1][target+1];
        
        for(int j=0;j<=target;j++){
            if(j%coins[0]==0) memo[0][j]=target/coins[0];
            else memo[0][j]=(int)1e9;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                int case1=memo[i-1][j];
                int case2=Integer.MAX_VALUE;
                if(coins[i-1]<=j) case2=1+memo[i][j-coins[i-1]];
                
                memo[i][j]=Math.min(case1,case2);
            }
        }
        
        int ans=memo[n][target];
        
        return ans>=(int)1e9?-1:ans;
    }
    
    private int helper(int[] coins,int target,int i){
        if(i==0){
            if(target%coins[i]==0) return target/coins[i];
            return (int)1e9;
        }    
        
        
        int notTake=helper(coins,target,i-1);
        int take=Integer.MAX_VALUE;
        if(coins[i]<=target) take=1+helper(coins,target-coins[i],i);
        
        return Math.min(take,notTake);
    }
}