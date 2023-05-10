//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        long[][] memo=new long[N+2][2];
        
        for(int i=N-1;i>=0;i--){
            
            memo[i][1]=Math.max(-prices[i]+memo[i+1][0],memo[i+1][1]);
            
            memo[i][0]=Math.max(prices[i]+memo[i+2][1],memo[i+1][0]);
        }
        
        return memo[0][1];
        
        // return helper(prices,0,1);
    }
    
    private long helper(long[] prices,int i,int buy){
        if(i>=prices.length) return 0;
        
        
        long case1,case2;
        if(buy==1){
            case1=-prices[i]+helper(prices,i+1,0);
            case2=0+helper(prices,i+1,1);
        }else{
            case1=prices[i]+helper(prices,i+2,1);
            case2=0+helper(prices,i+1,0);
        }
        
        return Math.max(case1,case2);
    }
}
