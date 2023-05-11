class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        memo=new int[n][n+1];
        
        for(int i=0;i<n;i++) for(int j=0;j<n+1;j++) memo[i][j]=-1;
        
       
        return helper(nums,0,-1);
    }
    
    private int helper(int[] nums,int i,int last_index){
        if(i==nums.length) return 0;
        
        if(memo[i][last_index+1]!=-1) return memo[i][last_index+1];
        
        int notTake=helper(nums,i+1,last_index);
        int take=0;    
        if(last_index==-1 || nums[last_index]<nums[i]) take=1+helper(nums,i+1,i);
        
        return memo[i][last_index+1]=Math.max(notTake,take);
    }
}