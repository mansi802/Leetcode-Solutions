class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
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
    
    private int helper(String text1,String text2,int i,int j){
        if(i==-1 || j==-1) return 0;
        
        if(text1.charAt(i)==text2.charAt(j))
            return 1+helper(text1,text2,i-1,j-1);
        else
            return Math.max(helper(text1,text2,i-1,j),helper(text1,text2,i,j-1));
        
    }
}