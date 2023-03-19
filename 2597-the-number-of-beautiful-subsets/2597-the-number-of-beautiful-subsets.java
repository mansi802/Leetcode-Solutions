class Solution {
    int count=0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        helper(nums,new HashSet<>(),0,k);
        return count-1;
        
    }
    
    private void helper(int[] nums,Set<Integer> set,int i,int k){
        count++;
        
        
        for(int j=i;j<nums.length;j++){
            if(!set.contains(nums[j]-k)){
                set.add(nums[j]);
                helper(nums,set,j+1,k);
                set.remove(nums[j]);
            }
        }
    }
}