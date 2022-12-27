class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        
        for(int i=0;i<n;i++){
            capacity[i]=capacity[i]-rocks[i];
        }
        
        Arrays.sort(capacity);
        
        int count=0;
        for(int i=0;i<n;i++){
            if(capacity[i]==0) count++;
            else if(additionalRocks>=capacity[i]){
                additionalRocks-=capacity[i];
                count++;
            }else if(additionalRocks<capacity[i]) break;
        }
        
        return count;
    }
}