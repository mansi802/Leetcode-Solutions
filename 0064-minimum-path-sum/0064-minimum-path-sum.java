class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] memo=new int[n][m];
        
        int[] prev=new int[m];
        int[] curr=new int[m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1) curr[j]=grid[i][j];
                else if(i==n-1) curr[j]=grid[i][j]+curr[j+1];
                else if(j==m-1) curr[j]=grid[i][j]+prev[j];
                else curr[j]=grid[i][j]+Math.min(prev[j],curr[j+1]);
            }
            
            prev=curr;
            
        }
        
        
        return curr[0];
    }
}