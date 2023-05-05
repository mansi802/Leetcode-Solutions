class Solution {
    int mod=(int)(1e9+7);
    int[][] memo;
    public int change(int amount, int[] coins) {
        int n=coins.length;
        memo=new int[n][amount+1];
        
        for(int j=0;j<amount+1;j++){
            if(j%coins[0]==0) memo[0][j]=1;
            else memo[0][j]=0;
        }
        
        for(int i=0;i<n;i++) memo[i][0]=1;
        
        for(int i=1;i<n;i++){
            for(int j=1;j<amount+1;j++){
                int notTake=memo[i-1][j];
                int take=0;
                if(coins[i]<=j) take=memo[i][j-coins[i]];
                
                memo[i][j]=(notTake+take);
            }
        }
                
        return memo[n-1][amount];
        // return helper(coins,n-1,amount);
    }
    
    private int helper(int[] coins,int i,int sum){
        if(i==0){
            if(sum%coins[i]==0) return 1;
            else return 0;
        }
        
        if(memo[i][sum]!=-1) return memo[i][sum];
        
        int notTake=helper(coins,i-1,sum);
        int take=0;
        if(coins[i]<=sum) take=helper(coins,i,sum-coins[i]);
        
        
        memo[i][sum]=notTake+take;
        return memo[i][sum];
    }
}