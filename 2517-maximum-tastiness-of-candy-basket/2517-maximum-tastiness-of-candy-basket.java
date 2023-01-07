class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n=price.length;
        
        Arrays.sort(price);
        
        int left=0,right=price[n-1]-price[0];
        
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(isValid(price,k,mid)){
                ans=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        
        return ans;
    }
    
    private boolean isValid(int[] price,int k,int mid){
        int i=0;
        
        for(int j=1;j<price.length;j++){
            if(price[j]-price[i]>=mid){
                k--;
                i=j;
            }
            
            if(k==1) return true;
        }
        
        return false;
    }
}