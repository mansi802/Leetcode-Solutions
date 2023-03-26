class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans=0;
        
        if(numOnes>=k) return k;
        else {
            ans+=numOnes;
            k=k-numOnes;
        }
        
        if(numZeros>=k) return ans;
        else{
            k=k-numZeros;
        }
        
        return ans-k;
    }
}