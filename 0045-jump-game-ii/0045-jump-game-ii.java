class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] memo=new int[n];
        int min;
        memo[n-1]=0;
        for(int i=n-2;i>=0;i--){
           min=Integer.MAX_VALUE-1;  
           for(int j=1;j<=nums[i] && i+j<n;j++)
               min=Math.min(memo[i+j],min);
            
           memo[i]=min+1; 
        }
        
        return memo[0];
    }
}