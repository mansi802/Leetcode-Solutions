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
                prices[i]=sc.nextInt();
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
        int n=prices.length;
        long[] next=new long[2];
        long[] curr;
        
        for(int i=n-1;i>=0;i--){
            curr=new long[2];
            for(int j=0;j<=1;j++){
                long profit=0;
                if(j==1){
                    long case1=-prices[i]+next[0];
                    long case2=0+next[1];
                    profit=Math.max(case1,case2);
                }else{
                    long case3=prices[i]+next[1];
                    long case4=0+next[0];
                    profit=Math.max(case3,case4);
                }
                
                curr[j]=profit;
               
            }
             next=curr;
        }
        
        return next[1];
        // return helper(prices,0,true);
    }
    
    private long helper(long[] prices,int i,boolean buy){
        if(i==prices.length) return 0;
        
        long profit=0;
        long case1,case2;
        if(buy){
            
            case1=-prices[i]+helper(prices,i+1,false);
            case2=0+helper(prices,i+1,true);
            
        }else{
            
            case1=prices[i]+helper(prices,i+1,true);
            case2=0+helper(prices,i+1,false);
        }
        
        return profit=Math.max(case1,case2);
    }
}