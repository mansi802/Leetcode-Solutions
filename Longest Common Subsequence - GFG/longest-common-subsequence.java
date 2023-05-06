//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String text1, String text2)
    {
        int n=text1.length(),m=text2.length();
        int[] prev=new int[m+1];
        
        
        for(int i=1;i<n+1;i++){
            int[] curr=new int[m+1];
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    curr[j]=1+prev[j-1];
                else
                    curr[j]=Math.max(prev[j],curr[j-1]);
            }
            prev=curr;
            // System.arraycopy(curr, 0, prev, 0, m + 1);
        }
        
        return prev[m];
    }
    
}