class Solution {
    public boolean canPlaceFlowers(int[] flowers, int total) {
        int n=flowers.length;
        
        int i=0;
        while(i<n && total>0){
            if(flowers[i]==1) i=i+2;
            else{
                boolean prev=(i==0)?true:(flowers[i-1]==0);
                boolean next=(i==n-1)?true:(flowers[i+1]==0);
                
                if(prev && next){
                    flowers[i]=1;
                    i=i+2;
                    total--;
                }else{
                    i++;
                }
            }
        }
        
        return total==0;
    }
}