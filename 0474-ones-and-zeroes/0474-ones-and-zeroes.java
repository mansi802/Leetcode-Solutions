class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][] memo=new int[m+1][n+1];
        
        
        for(String str:strs){
            int one=0,zero=0;
            for(char c:str.toCharArray()){
                if(c=='0') zero++;
                else one++;
            }
            
            for(int i=m;i>=zero;i--){
                for(int j=n;j>=one;j--){
                    memo[i][j]=Math.max(memo[i][j],1+memo[i-zero][j-one]);
                }
            }
            
            
        }
        
        return memo[m][n];
        // return helper(count,0,m,n,0,0);
    }
    
    private int helper(int[][] count,int i,int n,int m,int zero,int one){
        if(i==count.length || zero>m || one>n) return 0; 
        
        
        int notTake=helper(count,i+1,n,m,zero,one);
        int take=0;
        if(zero+count[i][0]<=m && one+count[i][1]<=n) 
            take=1+helper(count,i+1,n,m,zero+count[i][0],one+count[i][1]);
        
        return Math.max(take,notTake);
    }
}