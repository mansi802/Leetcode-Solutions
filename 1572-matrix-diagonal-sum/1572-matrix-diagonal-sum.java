class Solution {
    public int diagonalSum(int[][] matrix) {
        int n=matrix.length;
        int sum=0;
        int start=0,end=n-1;
        for(int i=0;i<n;i++){
            
            if(start==end) sum+=matrix[i][start];
            else sum+=matrix[i][start]+matrix[i][end];
            
            start++;
            end--;
        }
        
        return sum;
    }
}