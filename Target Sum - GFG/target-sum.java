//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] nums , int N, int target) {
        int n=nums.length;
        int sum=0,count=0;
        int i,j;
        for(i=0;i<n;i++)
        {
            sum=sum+nums[i];
            if(nums[i]==0)
                count++;
        }
        
        if(target>sum)
            return 0;
        
        if((sum+target)%2!=0)
            return 0;
        
        int s1=(sum+target)/2;
        
        int[][] t=new int[n+1][sum+1];
        
        for(j=1;j<=sum;j++)
            t[0][j]=0;
        
        for(i=0;i<=n;i++)
            t[i][0]=1;
        
        for(i=1;i<=n;i++)
            for(j=1;j<=sum;j++){
                if(nums[i-1]>j || nums[i-1]==0)
                    t[i][j]=t[i-1][j];
                else
                    t[i][j]=t[i-1][j]+t[i-1][j-nums[i-1]];
            }
        
        return (int)(Math.pow(2,count))*t[n][s1];
    }
};