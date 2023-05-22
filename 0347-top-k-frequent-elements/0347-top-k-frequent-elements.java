class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
       Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        
        for(int key:map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
            
            if(pq.size()>k) pq.remove();
        }
        
        int[] ans=new int[k];
        
        for(int i=0;i<k;i++) ans[i]=pq.remove()[0];
        
        return ans;
    }
}