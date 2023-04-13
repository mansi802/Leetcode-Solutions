class Solution {
    public int climbStairs(int n) {
        int[] memo=new int[n+1];
        
        if(n<=1) return n;
        
        memo[0]=0;
        memo[1]=1;
        memo[2]=2;
        
        for(int i=3;i<=n;i++) memo[i]=memo[i-1]+memo[i-2];
        
        return memo[n];
    }
    
    private int helper(int n){
        if(n<0) return 0;
        
        if(n==0) return 1;
        
        int left=helper(n-1);
        int right=helper(n-2);
        
        return left+right;
    }
}