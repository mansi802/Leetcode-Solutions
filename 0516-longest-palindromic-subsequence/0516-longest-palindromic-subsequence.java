class Solution {
    public int longestPalindromeSubseq(String s) {
       int n=s.length();
       
       StringBuilder sR=new StringBuilder();
        
       for(int i=n-1;i>=0;i--) sR.append(s.charAt(i));
        
        return twoD(s,sR.toString(),n);
    }
    
    private int twoD(String s,String sR,int n){
        int[][] memo=new int[n+1][n+1];
         for(int i=1;i<=n;i++){
           for(int j=1;j<=n;j++){
               if(s.charAt(i-1)==sR.charAt(j-1)) memo[i][j]=1+memo[i-1][j-1];
               else memo[i][j]=Math.max(memo[i][j-1],memo[i-1][j]);
           }
       } 
        
        return memo[n][n];
    }
    
    private int rescursion(String s,String sR,int i,int j,int n){
        if(i>=n || j>=n) return 0;
        
        if(s.charAt(i)==sR.charAt(j)) return 1+rescursion(s,sR,i+1,j+1,n);
        else return Math.max(rescursion(s,sR,i+1,j,n),rescursion(s,sR,i,j+1,n));
    }
}