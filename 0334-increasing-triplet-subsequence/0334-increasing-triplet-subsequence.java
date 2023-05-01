class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
        
        for(int num:nums){
            if(num<=min) min=num;
            else if(secondMin>num) secondMin=num;
            else if(secondMin<num) return true;
        }
        
        return false;
    }
}