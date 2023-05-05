//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    int[][] memo;
    public int cutRod(int price[], int n) {
        memo=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++) memo[i][j]=-1;
        }
        return helper(price,n,n);
    }
    
    private int helper(int[] price,int i,int len){
        if(i==0 || len==0) return 0;
        
        if(memo[i][len]!=-1) return memo[i][len];
        
        int notTake=helper(price,i-1,len);
        int take=0;
        if(i<=len) take=price[i-1]+helper(price,i,len-i);
        
        return memo[i][len]=Math.max(notTake,take);
    }
}