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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    int mod=(int)(1e9+7);
    public int countPartitions(int n, int d, int arr[]){
        int s=0;
        for(int a:arr) s+=a;
        
        if(s-d<0 || (s-d)%2!=0) return 0;
        
        return helper(n,arr,(s-d)/2);
    }
    
    private int helper(int n,int[] arr,int sum){
        int[][] memo=new int[n][sum+1];
	   
	   if(arr[0]==0) memo[0][0]=2;
	   else memo[0][0]=1;
	   
	   if(arr[0]!=0 && arr[0]<=sum) memo[0][arr[0]]=1;
	   
	   
	   for(int i=1;i<n;i++){
	       for(int j=0;j<sum+1;j++){
	           
	           int notTaken=memo[i-1][j];
	           int taken=0;
	           if(arr[i]<=j) taken=memo[i-1][j-arr[i]];
	           
	           memo[i][j]=(taken%mod+notTaken%mod)%mod;
	       }
	   }
	   
	   return memo[n-1][sum]%mod;
    }
    
    
}