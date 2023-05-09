class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length-1,m=matrix[0].length-1;
        int i=0,j=0;
        
        List<Integer> ans=new ArrayList<>();
        
        while(i<=n && j<=m){
            
            for(int k=j;k<=m;k++) ans.add(matrix[i][k]);
            i++;
            
            for(int k=i;k<=n;k++) ans.add(matrix[k][m]);
            m--;
            
            if(i<=n)
                for(int k=m;k>=j;k--) ans.add(matrix[n][k]);
            n--;
            
            if(j<=m)
                for(int k=n;k>=i;k--) ans.add(matrix[k][j]);
            j++;
        }
        
        return ans;
    }
}