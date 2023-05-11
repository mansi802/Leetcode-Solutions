class Solution {
    //longest common subsequnce
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        
        // int[][] memo=new int[n+1][m+1];
        int[] prev=new int[m+1];
        
        
        for(int i=1;i<n+1;i++){
            int[] curr=new int[m+1];
            for(int j=1;j<m+1;j++){
                if(nums1[i-1]==nums2[j-1]) curr[j]=1+prev[j-1];
                else curr[j]=Math.max(prev[j],curr[j-1]);
            }
            
            prev=curr;
        }
        
        return prev[m];
        // return helper(nums1,nums2,0,0);
    }
    
    private int helper(int[] nums1,int[] nums2,int i,int j){
        if(i==nums1.length || j==nums2.length) return 0;
        
        if(nums1[i]==nums2[j]) return 1+helper(nums1,nums2,i+1,j+1);
        
        return Math.max(helper(nums1,nums2,i+1,j),helper(nums1,nums2,i,j+1));
    }
}