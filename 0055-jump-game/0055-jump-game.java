class Solution {
    public boolean canJump(int[] nums) {
         int n=nums.length;
        boolean[] result=new boolean[n];
        
        result[n-1]=true;
        
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<=nums[i] && i+j<n ;j++){
                result[i]=result[i] || result[i+j];
                if(result[i]) break;
            }
        }
        
        return result[0];
    }
}