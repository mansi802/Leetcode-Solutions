class Solution {
    public int compress(char[] chars) {
        int i=0;
        int ans=0;
        
        int n=chars.length;
        
        while(i<n){
            int count=0;
            char curr=chars[i];
            
            while(i<n && curr==chars[i]){
                i++;
                count++;
            }
            
            chars[ans++]=curr;
            
            if(count!=1)
                for(char c:Integer.toString(count).toCharArray()) chars[ans++]=c;
        }
        
        return ans;
    }
}