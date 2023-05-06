class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        
        int[][] t=new int[n+1][m+1];
        StringBuilder s=new StringBuilder();
        int i,j;
        for(i=0;i<n+1;i++) t[i][0]=0;
        
        for(j=0;j<m+1;j++) t[0][j]=0;
        
        for(i=1;i<n+1;i++)
            for(j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        i=n;j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
                i--;j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    s.append(str1.charAt(i-1));
                    i--;
                }else{
                    s.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        
        while(i>0){
            s.append(str1.charAt(i-1));
            i--;
        }
        
        while(j>0){
            s.append(str2.charAt(j-1));
            j--;
        }
        
        s.reverse();
        
        return s.toString();
        
    }
}