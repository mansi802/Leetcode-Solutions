//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int nums[], int n) {
        // int[] memo=new int[n+1];
        
        int prev2=0,prev=0,curr=0;
        
        
        for(int i=1;i<=n;i++){
            if(i==1) curr=nums[i-1];
            else{
                int left=nums[i-1]+prev2;
            int right=0+prev;
            
            curr=Math.max(left,right);
            }
            
            prev2=prev;
            prev=curr;
        }
        
        return curr;
    }
    
    private int recursion(int[] nums,int i){
        if(i<0) return 0;
        
        if(i==0) return nums[i];
        
        int left=nums[i]+recursion(nums,i-2);
        int right=0+recursion(nums,i-1);
        
        return Math.max(left,right);
    }
}