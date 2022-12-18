class Solution {
    public int deleteGreatestValue(int[][] grids) {
        int n=grids.length;
        int m=grids[0].length;
        
        for(int[] grid:grids) Arrays.sort(grid);
        
        int result=0;
        for(int j=0;j<m;j++){
            int max=0;
            for(int i=0;i<n;i++){
                max=Math.max(max,grids[i][j]);
            }
            result+=max;
        }
        
        return result;
    }
}