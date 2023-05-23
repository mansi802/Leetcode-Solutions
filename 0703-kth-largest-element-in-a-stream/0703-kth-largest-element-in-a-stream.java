class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            if(pq.size()<k)  pq.offer(num);
            else if(pq.peek()<num){
                pq.remove();
                pq.offer(num);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()<k) pq.offer(val);
        else if(pq.peek()<val){
            pq.remove();
            pq.offer(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */