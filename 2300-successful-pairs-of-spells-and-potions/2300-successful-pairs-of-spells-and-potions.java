class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        
        Arrays.sort(potions);
        
        int[] ans=new int[n];
        
        int i=0;
        for(int spell:spells) ans[i++]=binarySearch(potions,m,success,spell);
        
        return ans;
        
        
    }
    
    private int binarySearch(int[] potions,int m,long success,int spell){
        int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        
        return m-left;
        
    }
    
    
}