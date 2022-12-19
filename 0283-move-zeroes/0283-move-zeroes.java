class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        while(j<n){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;
            }
            j++;
        }
    }
    
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}