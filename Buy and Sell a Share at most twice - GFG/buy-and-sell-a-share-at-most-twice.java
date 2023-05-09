//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        int[][] curr;
        int[][] next=new int[2][3];
        
        for(int i=n-1;i>=0;i--){
            curr=new int[2][3];
            for(int k=2;k>0;k--){
                
                
                curr[1][k]=Math.max(-price[i]+next[0][k],next[1][k]);
                
                curr[0][k]=Math.max(price[i]+next[1][k-1],next[0][k]);
            }
            
            next=curr;
        }
        
        return next[1][2];
        // return helper(price,0,2,1);
    }
    
    
    static int helper(int[] price,int i,int k,int buy){
        if(i==price.length || k==0) return 0;
        
        int case1,case2;
        if(buy==1){
            case1=-price[i]+helper(price,i+1,k,0);
            case2=0+helper(price,i+1,k,1);
        }else{
            case1=price[i]+helper(price,i+1,k-1,1);
            case2=0+helper(price,i+1,k,0);
        }
        
        return Math.max(case1,case2);
    }
}
        
