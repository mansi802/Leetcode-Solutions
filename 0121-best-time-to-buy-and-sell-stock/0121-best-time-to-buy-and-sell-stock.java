class Solution {
    public int maxProfit(int[] prices) {
        int ans=0,min=Integer.MAX_VALUE;
        
        for(int p:prices){
            min=Math.min(min,p);
            
            ans=Math.max(ans,p-min);
        }
        
        return ans;
    }
}