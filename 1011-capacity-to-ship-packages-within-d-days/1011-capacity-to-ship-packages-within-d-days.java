class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int max=Integer.MIN_VALUE,sum=0;
        
        for(int i:nums){
            max=Math.max(max,i);
            sum+=i;
        }
        
        int start=max,end=sum;
        int ans=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(nums,days,mid)){
                ans=Math.min(ans,mid);
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[] nums,int days,int mid){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>mid) return false;
            
            if(sum+nums[i]>mid){
                count++;
                sum=nums[i];
                
                if(count>days) return false;
            }else{
                sum+=nums[i];
            }
        }
        
        return true;
    }
}