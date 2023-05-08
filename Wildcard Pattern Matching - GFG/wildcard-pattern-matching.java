//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String p, String s)
    {
        int n=s.length();
        int m=p.length();
        
        boolean[][] memo=new boolean[n+1][m+1];
        
        memo[0][0]=true;
        
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*') memo[0][j]=true && memo[0][j-1];
            else memo[0][j]=false;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    memo[i][j]=memo[i-1][j-1];
                
                if(p.charAt(j-1)=='*')
                    memo[i][j]=memo[i-1][j] || memo[i][j-1];
                
            }
        }
        
        return memo[n][m]?1:0;
        
    }
}
