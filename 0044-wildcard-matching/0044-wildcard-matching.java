class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        
        boolean[][] memo=new boolean[n+1][m+1];
        
        memo[0][0]=true;
        
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*') memo[0][j]=true && memo[0][j-1];
            else memo[0][j]=false;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    memo[i][j]=memo[i-1][j-1];
                
                if(p.charAt(j-1)=='*')
                    memo[i][j]=memo[i-1][j] || memo[i][j-1];
                
            }
        }
        
        return memo[n][m];
        
        
        // return helper(s,p,n-1,m-1);
    }
    
    private boolean helper(String s,String p,int i,int j){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++) if(p.charAt(k)!='*') return false;
            return true;
        }
        
        
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            return helper(s,p,i-1,j-1);
        
        if(p.charAt(j)=='*')
            return helper(s,p,i-1,j) || helper(s,p,i,j-1);
        
        return false;
    }
}