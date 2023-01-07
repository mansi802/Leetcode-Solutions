class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        
        int start=0,end=n-1;
        
        int sum=gas[end]-cost[end];
        while(start<end){
            if(sum>=0){
                sum+=gas[start]-cost[start];
                start++;
            }else{
                end--;
                sum+=gas[end]-cost[end];
            }
        }
        
        return sum>=0?start:-1;
    }
}