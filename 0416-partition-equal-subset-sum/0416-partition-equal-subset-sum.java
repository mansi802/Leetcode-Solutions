class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i:arr) sum+=i;
        
        if(sum%2!=0) return false;
        
        int k=sum/2;
        // boolean[][] memo=new boolean[n+1][sum+1];
        boolean[] prev=new boolean[sum+1];
         
        if(arr[0]<=k)
            prev[arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];
        
                boolean taken = false;
                    if(arr[ind]<=target)
                        taken = prev[target-arr[ind]];
            
                cur[target]= notTaken||taken;
            }
            prev = cur;
        }
        
        return prev[k];
    }
}