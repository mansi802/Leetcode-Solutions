class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        
        for(int pile:piles) pq.add(pile);
        
        while(pq.size()>0 && k-->0){
            int peek=pq.poll();
            
            pq.add((peek+1)/2);
        }
        
        int ans=0;
        while(pq.size()>0) ans+=pq.poll();
        
        return ans;
    }
}