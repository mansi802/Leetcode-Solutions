class Solution {
    public int maxPoints(int[][] p) {
        int n=p.length;
        
        if(n<=2) return n;
        
        int result=2;
        int total=2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                total=2;
                
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        if((p[i][1]-p[j][1])*(p[i][0]-p[k][0])==(p[i][1]-p[k][1])*(p[i][0]-p[j][0])) total++;
                    }
                }
                
                result=Math.max(result,total);
            }
            
            
        }
        
        return result;
        
    }
}