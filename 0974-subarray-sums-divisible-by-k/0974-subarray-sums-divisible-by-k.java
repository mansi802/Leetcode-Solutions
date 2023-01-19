class Solution {
    public int subarraysDivByK(int[] nums, int K) {
       int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int value=sum%K;
            
            if(value<0) value+=K;
            
            if(map.containsKey(value)){
                count+=map.get(value);
                map.put(value,map.get(value)+1);
            }else{
                map.put(value,1);
            }
        }
        
        return count;
        
    }
}