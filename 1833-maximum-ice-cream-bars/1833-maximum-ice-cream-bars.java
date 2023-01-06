class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        
        Arrays.sort(costs);
        
        int ans=0;
        for(int cost:costs){
            if(coins-cost>=0){
                ans++;
                coins-=cost;
            }else{
                break;
            }
        }
        
        return ans;
        
    }
}