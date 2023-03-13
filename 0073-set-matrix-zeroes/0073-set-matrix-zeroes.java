class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i,j;
        
        boolean firstRow=false,firstCol=false;
        
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0) firstRow=true;
                    if(j==0) firstCol=true;
                    
                    matrix[0][j]=0;  //making first row as array to store all zero's
                    matrix[i][0]=0;  //making first col as array to store all the zero's
                }
            }
        }
        
        for(i=1;i<n;i++){
            for(j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        
        if(firstCol) 
            for(i=0;i<n;i++) matrix[i][0]=0;
        
        if(firstRow)
            for(j=0;j<m;j++) matrix[0][j]=0;
    }
}