class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        int[][] memo=new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++) memo[i][0]=1;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                memo[i][j]=(s.charAt(i-1)==t.charAt(j-1)?memo[i-1][j-1]:0)+memo[i-1][j];
            }
        }
        
        return memo[n][m];
        // return helper(s,t,n-1,m-1);
    }
    
    private int helper(String s,String t,int i,int j){
        if(j<0) return 1;
        if(i<0) return 0;
        
        if(s.charAt(i)==t.charAt(j))
            return helper(s,t,i-1,j-1)+helper(s,t,i-1,j);
        else
            return helper(s,t,i-1,j);
    }
}