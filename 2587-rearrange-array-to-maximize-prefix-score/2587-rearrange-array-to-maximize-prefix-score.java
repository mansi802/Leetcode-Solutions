class Solution {
    public int maxScore(int[] nums) {
        int n=nums.length;
        
        Arrays.sort(nums);
        long sum=0;
        int index=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            if(sum>0) index++;
            else break;
        }
        
        return index;
    }
} 