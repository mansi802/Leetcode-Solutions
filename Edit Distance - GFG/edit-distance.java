//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        
        int[][] memo=new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++)
            memo[i][0]=i;
        
        for(int j=0;j<m+1;j++)
            memo[0][j]=j;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    memo[i][j]=memo[i-1][j-1];
                else
                    memo[i][j]=1+
                    Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]));
            }
        }
        return memo[n][m];
   
    }
}