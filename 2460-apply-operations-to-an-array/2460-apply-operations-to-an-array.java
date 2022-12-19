class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        
        for(int i=0;i<n-1;i++) if(nums[i]==nums[i+1]){
            nums[i]=2*nums[i];
            nums[i+1]=0;
        }
        
        int i=0,j=0;
        //[1,2,2,1,1,0] -> [1,4,0,2,0,0]
        while(j<n){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        
        return nums;
    }
    
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}