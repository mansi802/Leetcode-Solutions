class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int[][] memo=new int[n+2][2];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
               int profit=0;
                if(j==1){

                    int BUY=-prices[i]+memo[i+1][0];
                    int NOT_BUY=0+memo[i+1][1];

                   profit=Math.max(BUY,NOT_BUY);


                }else{

                    int SELL=prices[i]+memo[i+2][1];
                    int NOT_SELL=0+memo[i+1][0];
                    profit=Math.max(SELL,NOT_SELL);
                }

                memo[i][j]=profit; 
            }
        }
        
        return memo[0][1];
        
        // return helper(prices,0,1);
    }
    
    private int helper(int[] prices,int i,int buy){
        if(i>=prices.length) return 0;
        
        int profit=0;
        if(buy==1){
            
            int BUY=-prices[i]+helper(prices,i+1,0);
            int NOT_BUY=0+helper(prices,i+1,1);
            
           profit=Math.max(BUY,NOT_BUY);
           
            
        }else{
            
            int SELL=prices[i]+helper(prices,i+2,1);
            int NOT_SELL=0+helper(prices,i+1,0);
            profit=Math.max(SELL,NOT_SELL);
        }
        
        return profit;
    }
}