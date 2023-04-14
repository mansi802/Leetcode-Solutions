class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[] memo=new int[m];
        int[] prev=new int[m];

        //space optimized solution
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    memo[j]=grid[i][j]==1?0:1;
                }else if(i==n-1){
                    memo[j]=grid[i][j]==1?0:memo[j+1];
                }else if(j==m-1){
                    memo[j]=grid[i][j]==1?0:prev[j];
                }else{
                    memo[j]=grid[i][j]==1?0:prev[j]+memo[j+1];
                }
            }
            prev=memo;
        }

        return prev[0];
    }
}