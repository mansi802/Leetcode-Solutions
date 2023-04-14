class Solution {
    public int uniquePaths(int n, int m) {
        int[] prev=new int[m];
        int[] memo=new int[m];

        //just change memo[i][j] -> memo[j] and memo[i+1][j] -> prev[j]
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    memo[j]=1;
                }else if(i==n-1){
                    memo[j]=1;
                }else if(j==m-1){
                    memo[j]=1;
                }else{
                    memo[j]=memo[j+1]+prev[j];
                }
            }
            prev=memo;
        }
        
        return prev[0];
    }
}