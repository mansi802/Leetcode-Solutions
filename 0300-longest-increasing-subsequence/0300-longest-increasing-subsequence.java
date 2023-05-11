class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        memo=new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake=memo[i+1][j+1];
                int take=0;
                if(j==-1 || nums[j]<nums[i]) take=1+memo[i+1][i+1];
                
                memo[i][j+1]=Math.max(notTake,take);
            }
        }
        
        return memo[0][-1+1];
        // return helper(nums,0,-1);
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