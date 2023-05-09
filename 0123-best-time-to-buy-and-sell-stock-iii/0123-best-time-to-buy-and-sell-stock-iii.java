class Solution {
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        // int[][][] memo=new int[n+1][2][3];
        int[][] next=new int[2][3];
        int[][] curr=new int[2][3];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=2;k>=1;k--){
                   int profit=0;
                    if(j==1){

                        int case1=-prices[i]+next[0][k];
                        int case2=0+next[1][k];
                        profit=Math.max(case1,case2);
                    }else{

                        int case3=prices[i]+next[1][k-1];
                        int case4=0+next[0][k];
                        profit=Math.max(case3,case4);

                    }

                   curr[j][k]=profit;
                }
            }
            
            next=curr;
        }
        
        return next[1][2];
        // return helper(prices,0,1,2);
    }
    
    private int helper(int[] prices,int i,int buy,int k){
        if(i==prices.length || k==0) return 0;
        
        int profit=0;
        if(buy==1){
            
            int case1=-prices[i]+helper(prices,i+1,0,k);
            int case2=0+helper(prices,i+1,1,k); 
            profit=Math.max(case1,case2);
        }else{
            
            int case3=prices[i]+helper(prices,i+1,1,k-1);
            int case4=0+helper(prices,i+1,0,k);
            profit=Math.max(case3,case4);
            
        }
        
        return profit;
    }
}