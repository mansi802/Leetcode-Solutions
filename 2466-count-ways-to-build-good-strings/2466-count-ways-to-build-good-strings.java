class Solution {
    int count=0;
    public int countGoodStrings(int low, int high, int zero, int one) {
        // helper(low,high,zero,one,0);
        int[] memo=new int[high+1];
        int mod=1000000007;
        memo[0]=1;
        
        for(int i=1;i<=high;i++){
            if(i-zero>=0) memo[i]=(memo[i]+memo[i-zero])%mod;
            if(i-one>=0) memo[i]=(memo[i]+memo[i-one])%mod;
            
            if(i>=low) count=(count+memo[i])%mod;
        }
        
        return count;
    }
    
    private void helper(int low,int high,int zero,int one,int len){
        if(len>high) return;
        
        if(len>=low && len<=high){
            count++;
            count=count%(1000000007);
        }
        
        helper(low,high,zero,one,len+zero);
        helper(low,high,zero,one,len+one);
        
    }
}