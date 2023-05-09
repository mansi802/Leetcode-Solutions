//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int n, int price[]) {
       int[][] curr;
        int[][] next=new int[2][K+1];
        
        for(int i=n-1;i>=0;i--){
            curr=new int[2][K+1];
            for(int k=K;k>0;k--){
                
                
                curr[1][k]=Math.max(-price[i]+next[0][k],next[1][k]);
                
                curr[0][k]=Math.max(price[i]+next[1][k-1],next[0][k]);
            }
            
            next=curr;
        }
        
        
        int ans=0;
        for(int k=1;k<=K;k++) ans=Math.max(ans,next[1][k]);
        
        return ans;
        
        
    }
}