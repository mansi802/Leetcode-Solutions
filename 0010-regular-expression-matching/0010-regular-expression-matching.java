class Solution {
    public boolean isMatch(String str, String pattern) {
        int n=pattern.length();
         int m=str.length();
         
         //pattern on y-axis , str on x-axis
         boolean[][] memo=new boolean[n+1][m+1];
         int i,j;
         memo[0][0]=true;
         for(i=1;i<n+1;i++){
             if(i>=2 && pattern.charAt(i-1)=='*') memo[i][0]=memo[i-2][0];
         }
         
         for(i=1;i<n+1;i++){
             for(j=1;j<m+1;j++){
                 char p=pattern.charAt(i-1);
                 char s=str.charAt(j-1);
                 
                 if(p=='.' || s==p) memo[i][j]=memo[i-1][j-1];
                 else if(p=='*'){
                     memo[i][j]=memo[i-2][j];
                     
                     if(pattern.charAt(i-2)=='.' || pattern.charAt(i-2)==s)
                         memo[i][j]=memo[i][j] || memo[i][j-1];
                 }
                 
             }
         }
         
         return memo[n][m];
       
    }
}